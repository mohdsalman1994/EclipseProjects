package com.aceprogrammer.basics.utilities;

/**
 * @author Salman Shaikh
 *
 */
public class StringNode
{
	// String data of the Node
	private String data;
	
	// a pointer to the next node
	private StringNode link;
	
	StringNode()
	{
	link = null;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public StringNode getLink() {
		return link;
	}

	public void setLink(StringNode link) {
		this.link = link;
	}
	
	
}
