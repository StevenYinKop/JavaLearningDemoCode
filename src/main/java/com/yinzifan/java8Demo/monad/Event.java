package com.yinzifan.java8Demo.monad;

import java.util.stream.Stream;

public class Event<T> {
    T data;

    public Event(T data) {
        this.data = data;
    }

    public static void main(String[] args) {
        Stream<Event<Integer>> s = Stream.of(
                new Event<>(1),
                new Event<>(2),
                new Event<>(3),
                new Event<>(0),
                new Event<>(5)
        );
        s.map(e -> e.map(Transformer::transform))
                .forEach(e -> System.out.println(e.data.message));
    }

    <R> Event<R> map(FN<T, R> fn) {
        return new Event<>(fn.apply(this.data));
    }

    @FunctionalInterface
    interface FN<A, B> {
        B apply(A a);
    }

    static class EventData {
        Integer id;
        String message;

        public EventData(Integer id, String message) {
            this.id = id;
            this.message = message;
        }
    }

    static class Transformer {
        static EventData transform(Integer id) {
            return switch (id) {
                case 0 -> new EventData(id, "Start");
                case 1 -> new EventData(id, "Running");
                case 2 -> new EventData(id, "Done");
                case 3 -> new EventData(id, "Fail");
                default -> new EventData(id, "Error");
            };
        }
    }

}
