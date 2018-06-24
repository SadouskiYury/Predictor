package by.htp.predictor.been;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class Client implements Comparable<Client> {
	private String name;
	private String surname;
	private Date dateOfVisit;
	private Map<Date, String> listStory;

	public Client() {
		this.listStory = new TreeMap<>();
	}

	public Client(String name, String surname, Date dateOfVisit) {
		this();
		this.name = name;
		this.surname = surname;
		this.dateOfVisit = dateOfVisit;
	}

	public Answer chousePredictiongetAnswer() {
		// if (this.getName()) проверка пользователя

		Map<Prediction, Queue<Answer>> predictions = FortuneTeller.showPredictions();
		Prediction choused = chousePrediction();
		Queue<Answer> answers = predictions.get(choused);
		Answer answer = null;
		Iterator<Answer> iter = answers.iterator();
		int i = new Random().nextInt(4);
		while (i >= 0) {
			answer = iter.next();
			i--;
		}

		listStoryAdd(dateOfVisit, predictionResult(choused, answer));

		System.out.println(answer.toString());
		return answer;

	}

	public Boolean showListStory() {
		for (Date s : listStory.keySet())
			System.out.println(new SimpleDateFormat("dd.MM.yyyy").format(s));
		return true;
	}

	private Prediction chousePrediction() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Select prediction [1-3]:");
		String numberOfPrediction = sc.next();
		Prediction target = new Prediction();
		flag: while (true) {
			switch (numberOfPrediction) {
			case "1":
				target = new Prediction("Love");
				break flag;
			case "2":
				target = new Prediction("Money");
				break flag;
			case "3":
				target = new Prediction("Accommodation");
				break flag;
			default:
				System.out.println("This target impossible");
				System.out.println("You entered incorect number");
				System.out.println("Select prediction [1-3]:");
				numberOfPrediction = sc.next();
			}

		}
		// sc.close();
		return target;
	}

	private String predictionResult(Prediction prediction, Answer answer) {
		String predictionResult = prediction.toString() + answer.toString();
		return predictionResult;
	}

	private void listStoryAdd(Date date, String result) {
		this.listStory.put(date, result);
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public synchronized Map<Date, String> getListStory() {
		return listStory;
	}

	public synchronized void setListStory(Map<Date, String> listStory) {
		this.listStory = listStory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfVisit == null) ? 0 : dateOfVisit.hashCode());
		result = prime * result + ((listStory == null) ? 0 : listStory.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (dateOfVisit == null) {
			if (other.dateOfVisit != null)
				return false;
		} else if (!dateOfVisit.equals(other.dateOfVisit))
			return false;
		if (listStory == null) {
			if (other.listStory != null)
				return false;
		} else if (!listStory.equals(other.listStory))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", surname=" + surname + ", dateOfVisit="
				+ new SimpleDateFormat("dd.MM.yy").format(dateOfVisit) + "]";
	}

	@Override
	public int compareTo(Client o) {
		return 0;
	}

}