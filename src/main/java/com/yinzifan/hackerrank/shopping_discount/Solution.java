package com.yinzifan.hackerrank.shopping_discount;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

enum Type {
    TYPE_0("0", (p, d) -> Math.max(d.getFactor(), 0)),
    TYPE_1("1",
            (p, d) -> Math.max(Long.valueOf(Math.round(p.getPrice() * (100 - d.getFactor()) / 100d)).intValue(), 0)),
    TYPE_2("2", (p, d) -> Math.max(p.getPrice() - d.getFactor(), 0));

    private String typeString;
    private BiFunction<Product, Discount, Integer> calculator;
    Type(String typeString, BiFunction<Product, Discount, Integer> calculator) {
        this.typeString = typeString;
        this.calculator = calculator;
    }

    public static Type parseType(String type) {
        return values()[Integer.valueOf(type)];
    }

    public BiFunction<Product, Discount, Integer> getCalculator() {
        return calculator;
    }

    public String getTypeString() {
        return typeString;
    }

}

class Result {
    private static final String EMPTY = "EMPTY";

    /*
     * Complete the 'findLowestPrice' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. 2D_STRING_ARRAY products
     *  2. 2D_STRING_ARRAY discounts
     */

    public static int findLowestPrice(List<List<String>> products, List<List<String>> discounts) {

        // ['10', 'd0', 'd1']

        // ['tag', 'type', 'amount']

        // type 0 
        // type 1
        // type 2

        List<Product> productList = products.stream().map(Result::assembleProductEntity).collect(Collectors.toList());
        Map<String, Discount> discountMap = discounts.stream().map(Result::assembleDiscountEntity)
                .collect(Collectors.toMap(Discount::getTag, Function.identity(), (m1, m2) -> m1));
        return productList.stream().map(product -> calculatePrice(product, discountMap))
                .collect(Collectors.summingInt(Integer::intValue));
    }

    private static Integer calculatePrice(Product product, Map<String, Discount> discountMap) {
        return product.getTags().stream().map(tag -> {
            Discount discount = discountMap.get(tag);
            if (discount == null) {
                return product.getPrice();
            }
            return discount.getType().getCalculator().apply(product, discount);
        }).filter(Objects::nonNull).min(Integer::compareTo).orElse(product.getPrice());
    }

    private static Product assembleProductEntity(List<String> productInfo) {
        return new Product(Double.valueOf(productInfo.get(0)).intValue(),
                productInfo.stream().skip(1L).filter(str -> !EMPTY.equals(str) && str != null)
                        .collect(Collectors.toList()));
    }

    private static Discount assembleDiscountEntity(List<String> discountInfo) {
        return new Discount(discountInfo.get(0), discountInfo.get(1), Integer.valueOf(discountInfo.get(2)));
    }

}

class Product {

    private Integer price;
    private List<String> tags;
    public Product(Integer price, List<String> tags) {
        this.price = price;
        this.tags = tags;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(final List<String> tags) {
        this.tags = tags;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(final Integer price) {
        this.price = price;
    }
}

class Discount {
    private String tag;
    private Type type;
    private Integer factor;

    public Discount(String tag, String type, Integer factor) {
        this.tag = tag;
        this.type = Type.parseType(type);
        this.factor = factor;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(final String tag) {
        this.tag = tag;
    }

    public Type getType() {
        return type;
    }

    public void setType(final Type type) {
        this.type = type;
    }

    public Integer getFactor() {
        return factor;
    }

    public void setFactor(final Integer factor) {
        this.factor = factor;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/test.txt"));

        int productsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int productsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> products = new ArrayList<>();

        IntStream.range(0, productsRows).forEach(i -> {
            try {
                products.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int discountsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int discountsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> discounts = new ArrayList<>();

        IntStream.range(0, discountsRows).forEach(i -> {
            try {
                discounts.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.findLowestPrice(products, discounts);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
