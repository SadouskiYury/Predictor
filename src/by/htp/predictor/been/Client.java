package by.htp.predictor.been;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class Client implements Comparable<Client> {
	private String name;
	private String surname;
	private GregorianCalendar dateOfVisit;
	private GregorianCalendar dateOfNextVisit;
	private Map<GregorianCalendar, String> listStory;

	public Client() {
		listStory = new TreeMap<>();
		dateOfNextVisit = new GregorianCalendar();
	}

	public Client(String name, String surname, GregorianCalendar dateOfVisit) {
		this();
		this.name = name;
		this.surname = surname;
		this.dateOfVisit = dateOfVisit;

	}

	public Boolean chousePredictiongetAnswer() {
		if (cheekClient()) {
			Map<PredictionEnum, Queue<Answer>> predictions = FortuneTeller.predictionsForUse();
			PredictionEnum choused = chousePrediction();
			Queue<Answer> answers = predictions.get(choused);
			Answer answer = null;
			Iterator<Answer> iter = answers.iterator();
			int i = new Random().nextInt(4);
			while (i >= 0) {
				answer = iter.next();
				i--;
			}
			dateOfNextVisit.setTime(dateOfVisit.getTime());
			dateOfNextVisit.add(Calendar.DAY_OF_MONTH, 7);
			listStoryAdd(dateOfVisit, predictionResult(choused, answer, dateOfNextVisit));
			System.out.println(this.name + " your " + answer.toString() + "\n");
		}
		return true;

	}

	private Boolean cheekClient() {
		if (listStory.isEmpty())
			return true;
		else if (this.dateOfVisit.after(dateOfNextVisit)) {
			return true;
		} else {
			System.out.println("Sorry,You can not get the prediction more than 1 time per week ");
			System.out.println("You will visit us: "
					+ new SimpleDateFormat("yyyy/MM/dd").format(dateOfNextVisit.getTime()) + "\n");
			return false;
		}
	}

	public Boolean showListStory() {
		if (this.listStory.isEmpty()) {
			System.out.println("List is empty" + "\n");
			return listStory.isEmpty();
		}
		System.out.println("ListStory");
		for (GregorianCalendar s : this.listStory.keySet()) {
			System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(s.getTime()) + listStory.get(s));
		}
		System.out.println("");
		return true;
	}

	private PredictionEnum chousePrediction() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Select prediction [1-3]:");
		String numberOfPrediction = sc.next();
		PredictionEnum target = PredictionEnum.LOVE;
		flag: while (true) {
			switch (numberOfPrediction) {
			case "1":
				target = PredictionEnum.LOVE;
				break flag;
			case "2":
				target = PredictionEnum.MONEY;
				break flag;
			case "3":
				target = PredictionEnum.ACCOMMODATION;
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

	private String predictionResult(PredictionEnum prediction, Answer answer, GregorianCalendar dateOfNextVisit) {
		String predictionResult = " Prediction <" + prediction.getValue()+"> " + answer.toString() + " , Your dateOfNextVisit:"
				+ new SimpleDateFormat("yyyy/MM/dd").format(dateOfNextVisit.getTime());
		return predictionResult;
	}

	private void listStoryAdd(GregorianCalendar dateOfVisit, String result) {
		this.listStory.put(dateOfVisit, result);
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public GregorianCalendar getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(GregorianCalendar dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<GregorianCalendar, String> getListStory() {
		return listStory;
	}

	public void setListStory(Map<GregorianCalendar, String> listStory) {
		this.listStory = listStory;
	}

	public GregorianCalendar getDateOfNextVisit() {
		return dateOfNextVisit;
	}

	public void setDateOfNextVisit(GregorianCalendar dateOfNextVisit) {
		this.dateOfNextVisit = dateOfNextVisit;
	}

	@Override
	public String toString() {
		return "Client [dateOfVisit= " + new SimpleDateFormat("yyyy/MM/dd").format(dateOfVisit.getTime())
				+ " ,surname= " + surname + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Client o) {

		return this.dateOfVisit.compareTo(o.dateOfVisit);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfNextVisit == null) ? 0 : dateOfNextVisit.hashCode());
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
		if (dateOfNextVisit == null) {
			if (other.dateOfNextVisit != null)
				return false;
		} else if (!dateOfNextVisit.equals(other.dateOfNextVisit))
			return false;
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

}