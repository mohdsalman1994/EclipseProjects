package com.aceprogrammer.basics.utilities;

/**
 * @author Salman Shaikh
 *
 */
public class UnorderedLinkedList {
	

	
	private StringNode p = null;
	
	// used to count total nodes in our Linked List
	int count = 0;
	
	/**
	 * @param value i.e. the value to be appended in the list
	 * This method appends the given string at the end of the list.
	 */
	public void append(String value)
	{		
		StringNode q;
		
		StringNode temp = new StringNode();
		temp.setData(value);
		temp.setLink(null);
		
		if(p == null)
		{
			System.out.println("Creating the list");
			p = temp;
			System.out.println("Node added successfully");
			count++;
		}
		
		else
		{
			q = p;
			
			while(q.getLink()!= null)
			{
				q = q.getLink();
			}
			
			q.setLink(temp);
			count++;
			
			
		}
		
	}
	
	
	/**
	 * Displays all the nodes of the linked list
	 */
	public void display()
	{
		StringNode q;
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
	 * @param value i.e. the value to be inserted in the list
	 * Tries to insert the given value if not present in the list.
	 * Removes the given value if already present.
	 */
	public void insert(String value)
	{						
		
		StringNode q, old;
		boolean found = false;
		
		q=p;
		old = p;
				
		if(q!= null)
		{
			
			while(q!= null)
			{
								
				if(q.getData().equals(value))
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
	 * @return array of Strings
	 * @throws RuntimeException
	 * This method converts our Linked List to an Array of Strings
	 */
	public String[] toWordArray() throws RuntimeException
	{
		if(count == 0)
		{
			throw new RuntimeException("List is empty");
		}
		
		else
			
		{
			String[] words = new String[count];
			StringNode q=p;
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
