import java.util.*;

class ListTest
{
	public static void main(String[] args)
	{
		

		String[] letters = {"a", "b", "c", "a", "c", "d", "e", "a"};
		String[] letters1 = {"b", "c", "a", "c", "d", "e", "a"};
		String[] letters2 = new String[5];
		//String[] letters3 = {"a", "a", "a", "a"};
		//String[] letters3 = {"a", "b", "b", "a"};
		//String[] letters3 = {"b", "b", "b", "b"};
		//String[] letters3 = {"a", "a", "b", "a", "a"};
		//String[] letters3 = {"a", "b", "a", "a", "a"};
		
		//String[] letters3 = {"a", "a", "a", "a", "b", "a"};
		//String[] letters3 = {"b", "a", "a", "a"};
		//String[] letters3 = {"a", "a", "a", "a", "b"};
		String[] letters3 = new String[5];

	
		System.out.println("ArrayList Tests: ");
		System.out.println("################");
		System.out.println();

		ArrayList list1 = new ArrayList(letters);
		System.out.println(list1.toString());

		System.out.println("Can 'a' be removed?: " + list1.removeAll("a"));
		System.out.println(list1.toString());

		System.out.println("Can 'a' be removed?: " + list1.removeAll("a"));
		System.out.println(list1.toString());

		System.out.println("Can 'x' be removed?: " + list1.removeAll("x"));
		System.out.println(list1.toString());

		System.out.println("Can 'c' be removed?: " + list1.removeAll("c"));
		System.out.println(list1.toString());

		System.out.println("Can 'd' be removed?: " + list1.removeAll("d"));
		System.out.println(list1.toString());

		ArrayList list3 = new ArrayList(letters3);
		System.out.println(list3.toString());

		System.out.println("Can 'a' be removed?: " + list3.removeAll("a"));
		System.out.println(list3.toString());

		

	/*
		// Null List Test
		ArrayList listEmpty = new ArrayList(letters2);
		System.out.println(listEmpty.toString());
		System.out.println();

		System.out.println("Can 'z' be removed?: " + listEmpty.removeAll("z"));
		System.out.println(listEmpty.toString());
	*/

		System.out.println();

		System.out.println("LLList Tests: ");
		System.out.println("#############");
		System.out.println();

		LLList list2 = new LLList(letters);
		System.out.println(list2.toString());

		System.out.println("Can 'a' be removed?: " + list2.removeAll("a"));
		System.out.println(list2.toString());

		System.out.println("Can 'a' be removed?: " + list2.removeAll("a"));
		System.out.println(list2.toString());

		System.out.println("Can 'x' be removed?: " + list2.removeAll("x"));
		System.out.println(list2.toString());

		System.out.println("Can 'c' be removed?: " + list2.removeAll("c"));
		System.out.println(list2.toString());


		System.out.println("Can 'd' be removed?: " + list2.removeAll("d"));
		System.out.println(list2.toString());

		LLList list4 = new LLList(letters3);
		System.out.println(list4.toString());

		System.out.println("Can 'a' be removed?: " + list4.removeAll("a"));
		System.out.println(list4.toString());

/*
		// Null List Test
		LLList listEmpty2 = new LLList(letters2);
		System.out.println(listEmpty2.toString());

		System.out.println("Can 'a' be removed?: " + listEmpty2.removeAll("a"));
		System.out.println(listEmpty2.toString());
*/
	

	}

}