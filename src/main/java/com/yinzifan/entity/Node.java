package com.yinzifan.entity;

import java.util.List;

public class Node {
	private String id;
	private String name;
	private String pid;
	private List<Node> children;

	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Node(String id, String name, String pid, List<Node> children) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", name=" + name + ", pid=" + pid + ", children=" + children + "]";
	}

}
