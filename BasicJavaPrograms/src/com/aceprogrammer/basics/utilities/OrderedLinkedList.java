package com.aceprogrammer.basics.utilities;

/**
 * @author Salman Shaikh
 *
 */
public class OrderedLinkedList {

	// the node of Linked List	
	private IntegerNode p = null;
	
	// used to keep count of total nodes in the linked list
	private int count = 0;
	
	
	/**
	 * @param args
	 * This app is used to simulate an Ordered Linked List
	 */
	public static void main(String[] args) {
		int[] test = { 55, 22, 13, 34, 18};
		OrderedLinkedList ol = new OrderedLinkedList();
		for (int i = 0; i < test.length; i++) {
			ol.append(test[i]);
		}
		
		ol.display();
	}
	
	
	/**
	 * @param value i.e. the value to be appended
	 * This method appends a node with the given value
	 * in the linked list.
	 */
	public void append(int value)
	{		
		IntegerNode q;
		IntegerNode next;
		
		IntegerNode temp = new IntegerNode();
		temp.setData(value);
		temp.setLink(null);
		
		
		// the list is empty
		if(p == null)
		{
			System.out.println("Creating the list");
			p = temp;						
		}
		
		else
			
			// if the given value is less than the first value
			if(value <= p.getData())
			{
				
				System.out.println("Less than first value");
				temp.setLink(p);
				p = temp;
			}
		
		else
		{
			boolean ins = false;
			q = p;
            next = p.getLink();
            while(next != null && ins == false)
            {
                if (value > q.getData() && value < next.getData())
                {
                    q.setLink(temp);
                    temp.setLink(next);
                    ins = true;                    
                }
                else
                {
                    q = next;
                    next = next.getLink();
                }
            }
            if (ins == false)
            {
                q.setLink(temp);
            }
		}
		
		count++;
		
	}
	
	
	/**
	 * This method displays all the nodes in
	 * the linked list.
	 */
	public void display()
	{
		IntegerNode q;
		q = p;
		
		if(q == null)
		{
			System.out.println("List is empty");
		}
		
		else
			
			while(q!= null)
			{
				System.out.print(q.getData()+" ");
				q = q.getLink();
			}
		System.out.println();
	}
	
	
	/**
	 * @param value i.e. the value to be inserted
	 * This method tries to insert the given value
	 * if the value is not already present.
	 * If the value is already present, then
	 * it is removed from the list.
	 */
	public void insert(int value)
	{						
		
		IntegerNode q, old;
		boolean found = false;
		
		q=p;
		old = p;

		if(q!= null)
		{
			
			while(q!= null)
			{
								
				if(q.getData() == value)
				{
					if(q == p)
					{
						q = q.getLink();
						found = true;
					}
					else
					{
					old.setLink(q.getLink());
					found = true;
					q = null;
					}
					System.out.println("Value found and deleted");
					count--;
				}
				
				else
				{					
					old = q;
					q=q.getLink();
				}
			} // end while
		}
			
			if(found == false)					
			{
				System.out.println("Trying to append");
				
				append(value);
			}
					
		
	}
	
	/**
	 * @return an array of integers
	 * used to convert our list to array of integers. 
	 */
	public int[] toIntegerArray()
	{
		if(count == 0)
		{
			throw new RuntimeException("List is empty");
		}
		
		else
			
		{
			System.out.println(count);
			int[] words = new int[count];
			IntegerNode q=p;
			int i = 0;
			while(q!= null)
			{
				words[i] = q.getData();
				q = q.getLink();
				i++;
			}
			
			return words;
		}
			
	}

}
