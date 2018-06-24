package by.htp.predictor.been;

import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

public class FortuneTeller {
	private String name;
	private double price;
	private Queue<Client> priorityQueue;
	private Map<Date, Client> clientList;
	private NavigableSet<Client> waitingList;
	static private int counterClientaDay;

	public FortuneTeller() {
		this.priorityQueue = new PriorityQueue<>();
		this.clientList = new HashMap<>();
		this.waitingList = new TreeSet<>(new Comparator<Client>() {

			@Override
			public int compare(Client o1, Client o2) {
				int result = o1.getDateOfVisit().compareTo(o2.getDateOfVisit());
				if (result == 0) {
					int result1 = o1.getSurname().compareToIgnoreCase(o2.getSurname());
					if (result1 == 0) {
						return o1.getName().compareToIgnoreCase(o2.getName());
					}
					return result1;
				}

				return result;

			}

		});

	}

	public FortuneTeller(String name, double price) {
		this();
		this.name = name;
		this.price = price;
	}

	public void clientList(Client name) {
		// Map<Date, Client> clientList = new HashMap<>();

	}

	public void waitingList(Client name) {

		// NavigableSet< Client> waitingList = new TreeSet<>();

	}

	public void joinQueueClient(Client client) {
		Date date = new Date();
		int dateToday = date.getDate();
		if (counterClientaDay <= 10) {
			if (dateToday == client.getDateOfVisit().getDate()) {
				priorityQueue.offer(client);
				clientList.put(client.getDateOfVisit(), client);
				counterClientaDay++;
				System.out.println(client.getSurname() + " " + client.getName() + " your number in the Queue : "
						+ counterClientaDay);
			} else if (dateToday > client.getDateOfVisit().getDate()) {
				System.out.println("Your date in the past");
			} else if (dateToday < client.getDateOfVisit().getDate()) {
				System.out.println("You added in waitingList");
				waitingList.add(client);
			}

		} else {
			System.out.println("Sorry,today the reception is over,You added in waitingList");
			waitingList.add(client);
		}

	}

	public Client nextClientFromQueue() {
		Client next = priorityQueue.poll();
		
		return next;
	}

	public static Map showPredictions() {
		Queue<Answer> answerforFirts = new LinkedList<>();
		answerforFirts.add(new Answer("Fortunately, You will meet yout love today!))"));
		answerforFirts.add(new Answer("Unfortunately,You will be alone all long your life (("));
		answerforFirts.add(new Answer("You will get married this year!"));
		answerforFirts.add(new Answer("Yoy will have five children!"));

		Queue<Answer> answerForSecond = new LinkedList<>();
		answerForSecond.add(new Answer("You wil be very rich, my congratulations."));
		answerForSecond.add(new Answer("Unfortunately,You will be poor (("));
		answerForSecond.add(new Answer("You will get new car this year!!"));
		answerForSecond.add(new Answer("Yoy will win a lot of money!!!"));

		Queue<Answer> answerForThird = new LinkedList<>();
		answerForThird.add(new Answer("Fortunately, You will live in a big house near the see))"));
		answerForThird.add(new Answer("Unfortunately,You will be live in the street((( "));
		answerForThird.add(new Answer("You will get a new flat!!"));
		answerForThird.add(new Answer("Yoy will have a small house in the vilage!"));

		Map<Prediction, Queue<Answer>> predictions = new LinkedHashMap<>();
		predictions.put(new Prediction(1, "Love"), answerforFirts);
		predictions.put(new Prediction(2, "Money"), answerForSecond);
		predictions.put(new Prediction(3, "Accommodation"), answerForThird);

		for (Prediction target : predictions.keySet()) {
			System.out.println(target);
		}

		return predictions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Queue<Client> getPriorityQueue() {
		return priorityQueue;
	}

	public void setPriorityQueue(Queue<Client> priorityQueue) {
		this.priorityQueue = priorityQueue;
	}

	public Map<Date, Client> getClientList() {
		return clientList;
	}

	public void setClientList(Map<Date, Client> clientList) {
		this.clientList = clientList;
	}

	public NavigableSet<Client> getWaitingList() {
		return waitingList;
	}

	public void setWaitingList(NavigableSet<Client> waitingList) {
		this.waitingList = waitingList;
	}

	public static int getCounterClientaDay() {
		return counterClientaDay;
	}

	public static void setCounterClientaDay(int counterClientaDay) {
		FortuneTeller.counterClientaDay = counterClientaDay;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "FortuneTeller [name=" + name + ", price=" + price + ", priorityQueue=" + priorityQueue + ", clientList="
				+ clientList + ", waitingList=" + waitingList + "]";
	}

}
