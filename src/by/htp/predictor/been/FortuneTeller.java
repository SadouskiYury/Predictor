package by.htp.predictor.been;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.GregorianCalendar;
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
	private Map<Integer, Client> clientList;
	private NavigableSet<Client> waitingList;
	static private int counterClientaDay;
	static private int counterClient;
	static private GregorianCalendar dateToday;

	public FortuneTeller() {
		dateToday = new GregorianCalendar();
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

	public Boolean showClientList() {
		if (clientList.isEmpty()) {
			System.out.println("ClientList is empty" + "\n");
			return clientList.isEmpty();
		}
		System.out.println("ClientList");
		for (Integer s : clientList.keySet()) {
			System.out.println(s + ":" + clientList.get(s));
		}
		System.out.println("");
		return true;
	}

	public Boolean showWaitingList() {

		if (waitingList.isEmpty()) {
			System.out.println("WaitingList is empty" + "\n");
			return waitingList.isEmpty();
		}
		System.out.println("WaitingList");
		for (Client s : waitingList) {
			System.out.println(s.toString());
		}
		System.out.println("");
		return true;
	}

	public void deletedFromWaitingList(Client client) {
		waitingList.remove(client);
	}

	public Boolean showQueueClient() {
		System.out.println("QueueClient");
		if (priorityQueue.isEmpty()) {
			System.out.println("PriorityQueue is empty" + "\n");

			return priorityQueue.isEmpty();
		}
		for (Client s : priorityQueue) {
			System.out.println(s.toString());
		}
		System.out.println("");
		return true;

	}

	public void joinQueueClient(Client client) {
		DateFormat dF = new SimpleDateFormat("yyyy/MM/dd");

		if (counterClientaDay < 10) {
			if (dF.format(dateToday.getTime()).compareTo(dF.format(client.getDateOfVisit().getTime())) == 0) {
				priorityQueue.offer(client);
				counterClientaDay++;
				System.out.println(client.getSurname() + " " + client.getName() + " your number in the Queue : "
						+ counterClientaDay);
			} else if (dF.format(dateToday.getTime()).compareTo(dF.format(client.getDateOfVisit().getTime())) > 0) {
				System.out.println("It is impossible, Your date in the past" + "\n");
			} else if (dF.format(dateToday.getTime()).compareTo(dF.format(client.getDateOfVisit().getTime())) < 0) {
				System.out.println(client.getName() + " You added in waitingList" + "\n");
				waitingList.add(client);
			}

		} else {
			System.out.println(client.getName() + " Sorry,today the reception is over,You added in waitingList" + "\n");
			waitingList.add(client);
		}

	}

	public Client nextClientFromQueue() {
		Client next = this.priorityQueue.poll();
		clientList.put(++counterClient, next);
		return next;
	}

	public Boolean showPredictions() {
		System.out.println("Price for services " + name + ": " + price + "$");
		Map<PredictionEnum, Queue<Answer>> predictions = predictionsForUse();
		System.out.println("");
		return true;
	}

	public static Map<PredictionEnum, Queue<Answer>> predictionsForUse() {
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
		PredictionEnum prediction1=PredictionEnum.LOVE;
		PredictionEnum prediction2=PredictionEnum.MONEY;
		PredictionEnum prediction3=PredictionEnum.ACCOMMODATION;
		Map<PredictionEnum, Queue<Answer>> predictions = new LinkedHashMap<>();
		predictions.put(prediction1, answerforFirts);
		predictions.put(prediction2, answerForSecond);
		predictions.put(prediction3, answerForThird);

		for (PredictionEnum target : predictions.keySet()) {
			System.out.println("["+target.getNumber()+"]"+target.getValue());
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

	public Map<Integer, Client> getClientList() {
		return clientList;
	}

	public void setClientList(Map<Integer, Client> clientList) {
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
