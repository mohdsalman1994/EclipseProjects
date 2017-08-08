package com.aceprogrammer.basics.utilities;

/**
 * @author Salman Shaikh
 *
 */
public class IntegerNode
{
	// data stored in each node
	private int data;
	
	// pointer to the next node in the linked list
	private IntegerNode link;
	
	IntegerNode()
	{
	link = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public IntegerNode getLink() {
		return link;
	}

	public void setLink(IntegerNode link) {
		this.link = link;
	}
	
	
}
