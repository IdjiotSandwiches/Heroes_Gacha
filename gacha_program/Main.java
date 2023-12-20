package gacha_program;

import java.util.*;

public class Main {
	Scanner o = new Scanner(System.in);
	Random rnd = new Random();
	// Using Vector in Vector
	Vector<Vector<Hero>> bankHero = new Vector<Vector<Hero>>();
	Vector<Hero> collection = new Vector<Hero>(); 
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		initData();
		mainMenu();
		o.close();
	}
	
	//	Initial Data
	public void initData() {
		Vector<Hero> gradeA = new Vector<Hero>();
		Vector<Hero> gradeB = new Vector<Hero>();
		Vector<Hero> gradeC = new Vector<Hero>();
		
		gradeA.addAll(Arrays.asList(
			new Hero("Ryzalia", 10, "A"),
			new Hero("Ryxa", 9, "A")
		));
		gradeB.addAll(Arrays.asList(
			new Hero("Kiryuu", 8, "B"),
			new Hero("Nephilia", 8, "B")
		));
		gradeC.addAll(Arrays.asList(
			new Hero("Slimy", 6, "C"),
			new Hero("Kolua", 6, "C"),
			new Hero("Mysty", 5, "C"),
			new Hero("Werner", 4, "C")
		));
		
		// Adding gradeA, gradeB, gradeC vector to bankHero Vector
		bankHero.add(gradeA);
		bankHero.add(gradeB);
		bankHero.add(gradeC);
		
	}
	
	//	Main Menu
	public void mainMenu() {
		Integer choice = 0;
		do {
			System.out.println("Welcome to Heroes Gacha");
			System.out.println("=======================");
			System.out.println("1. Gacha");
			System.out.println("2. View collection");
			System.out.println("3. Retire Heroes");
			System.out.println("4. Exit");
			System.out.print(">> ");
			
			try {
				choice = o.nextInt();
			}
			catch(Exception e) {
				System.out.println("Invalid input!");
				o.next();
			}
			finally {
				o.nextLine();
			}
			
			switch(choice) {
				case 1:
					gacha();
					break;
				case 2:
					viewCollection();
					break;
				case 3:
					retireHeroes();
					break;
				default:
					break;
			}
			
		} while(choice != 4);
		
	}
	
	//	Randomizer to random grade
	public void gacha() {
		Integer random = rnd.nextInt(1000) + 1;
		
		if(random > 0 && random <= 100) {
			heroGacha(0);
		}
		else if(random > 100 && random <= 400) {
			heroGacha(1);
		}
		else {
			heroGacha(2);
		}
		
		Integer size = collection.size() - 1;
		System.out.println("You get new hero: ");
		collection.get(size).display(1);
		System.out.println();
	}
	
	//	Randomizer for heroes at specific grade
	public void heroGacha(Integer index) {
		Vector<Hero> grade = bankHero.get(index);
		Integer size = grade.size();
		Integer randomGrade = rnd.nextInt(size);
		
		collection.add(grade.get(randomGrade));
	}
	
	//	View Collection
	public void viewCollection() {
		if(collection.isEmpty()) {
			System.out.println("There is no heroes in collection!\n");
			return;
		}
		
		Integer counter = 0;
		for(Hero collections : collection) {
			collections.display(++counter);
			System.out.println("============================================================");
		}
	}
	
	//	Delete heroes	
	public void retireHeroes() {
		if(collection.isEmpty()) {
			System.out.println("There is no heroes to be retired!\n");
			return;
		}
		
		Integer choice = 0;
		
		do {
			Integer counter = 0;
			for(Hero collections : collection) {
				collections.display(++counter);
				System.out.println("============================================================");
			}
			
			System.out.println("Choose number of heroes that want to be retired");
			System.out.print(">> ");
			
			try {
				choice = o.nextInt();
			}
			catch(Exception e) {
				System.out.println("Invalid input!");
				o.next();
			}
			finally {
				o.nextLine();
			}
			
			if(choice < 1 || choice > collection.size()) {
				System.out.println("Out of bound!\n");
			}
			
		} while(choice < 1 || choice > collection.size());
		
		collection.remove(choice - 1);
		System.out.println("Hero has been retired!");
		System.out.println("Press enter to continue...");
		o.nextLine();
		
	}
	
}
