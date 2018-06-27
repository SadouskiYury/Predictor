package by.htp.predictor.run;

import java.util.Calendar;
import java.util.GregorianCalendar;

import by.htp.predictor.been.Client;
import by.htp.predictor.been.FortuneTeller;

/*
 *  Предсказатель (FortuneTeller) - класс, у которого хранится: 
 *  набор гаданий и набор ответов для каждого гадания (LinkedHashMap<Prediction, Queue<Answer>),
 *  очередь клиентов (PriorityQueue<Client>).
 *  предсказатель ведёт учёт клиентов (HashMap<Integer, Client>).
 *  
 *  Клиент хранит историю обращений к предсказателю (TreeMap <Date, PredictionResult> ) 
 *  PredictionResult = Prediction + Answer.
 *  
 *  Реализовать следующие функциональные возможности:
 *  клиент может просмотреть список доступных предсказаний; 
 *  клиент может обратиться к предсказателю, указать цель гадания, получить ответ;
 *  клиент не может обращаться чаще одного раза в неделю,
 *  если клиент обращается чаще одного раза в неделю, 
 *  либо на дату обращения превышен лимит предсказателя ( 10 предсказаний в сутки), 
 *  клиент попадает в лист ожидания.
 *  предсказатель предоставляет возможность просмотра списка клиентов, записанных в очередь; 
 *  предсказатель имеет возможность удалять клиента из списка ожидания.
 * 
 */
public class PredictionResult {

	public static void main(String[] args) {

		FortuneTeller amanda = new FortuneTeller("Amanda", 25.00);
		amanda.showPredictions();
		GregorianCalendar dateToday=new GregorianCalendar();
		
		Client first = new Client("Vasya", "Petrov", dateToday);
		amanda.joinQueueClient(first);
		Client second = new Client("Marina", "Kuzmena",dateToday);
		amanda.joinQueueClient(second);
		Client third = new Client("Volodya", "Klimov", dateToday);
		amanda.joinQueueClient(third);
		Client fourth = new Client("Olya", "Baturina", dateToday);
		amanda.joinQueueClient(fourth);
		Client fifth = new Client("Kseniya", "Sobchak", dateToday);
		amanda.joinQueueClient(fifth);
		Client sixth = new Client("Petya", "Sidor", dateToday);
		amanda.joinQueueClient(sixth);
		Client seventh = new Client("Polina", "Shevchenko", dateToday);
		amanda.joinQueueClient(seventh);
		Client seventh2 = new Client("Violeta", "Mazur", dateToday);
		amanda.joinQueueClient(seventh2);
		Client eighth = new Client("Yury", "Sadouski", dateToday);
		amanda.joinQueueClient(eighth);
		Client ninth = new Client("Katya", "Malishko", dateToday);
		amanda.joinQueueClient(ninth);
		Client tenth = new Client("Pavel", "Olhovik",dateToday);
		amanda.joinQueueClient(tenth);
		Client eleventh = new Client("Volfram", "Gvozd",dateToday);
		amanda.joinQueueClient(eleventh);

		amanda.showQueueClient();

		amanda.showWaitingList();
		amanda.deletedFromWaitingList(eleventh);
		amanda.showWaitingList();

		amanda.nextClientFromQueue().chousePredictiongetAnswer();
		first.showListStory();
		amanda.nextClientFromQueue().chousePredictiongetAnswer();
		second.showListStory();
		amanda.nextClientFromQueue().chousePredictiongetAnswer();
		amanda.nextClientFromQueue().chousePredictiongetAnswer();
		amanda.nextClientFromQueue().chousePredictiongetAnswer();
		System.out.println("");
		amanda.showClientList();
		dateToday.add(Calendar.DAY_OF_MONTH, 3);
		first.setDateOfVisit(dateToday);
		first.chousePredictiongetAnswer();
		first.showListStory();
	}

}
