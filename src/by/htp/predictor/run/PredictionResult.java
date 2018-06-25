package by.htp.predictor.run;

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
		Client first = new Client("Vasya", "Petrov", new GregorianCalendar(2018, 05, 25));
		amanda.joinQueueClient(first);
		Client second = new Client("Marina", "Kuzmena", new GregorianCalendar(2018, 05, 25));
		amanda.joinQueueClient(second);
		Client third = new Client("Volodya", "Klimov", new GregorianCalendar(2018, 05, 25));
		amanda.joinQueueClient(third);
		Client fourth = new Client("Olya", "Baturina", new GregorianCalendar(2018, 05, 25));
		amanda.joinQueueClient(fourth);
		Client fifth = new Client("Kseniya", "Sobchak", new GregorianCalendar(2018, 05, 25));
		amanda.joinQueueClient(fifth);
		Client sixth = new Client("Petya", "Sidor", new GregorianCalendar(2018, 05, 24));
		amanda.joinQueueClient(sixth);
		amanda.showQueueClient();
		

		Client seventh = new Client("Polina", "Shevchenko", new GregorianCalendar(2018, 06, 26));
		amanda.joinQueueClient(seventh);
		Client seventh2 = new Client("Violeta", "Mazur", new GregorianCalendar(2018, 05, 28));
		amanda.joinQueueClient(seventh2);
		Client eighth = new Client("Yury", "Sadouski", new GregorianCalendar(2018, 05, 25));
		amanda.joinQueueClient(eighth);
		Client ninth = new Client("Katya", "Malishko", new GregorianCalendar(2018, 05, 25));
		amanda.joinQueueClient(ninth);
		Client tenth = new Client("Pavel", "Olhovik", new GregorianCalendar(2018, 05, 25));
		amanda.joinQueueClient(tenth);
		amanda.showWaitingList();
		System.out.println("");
		amanda.deletedFromWaitingList(seventh);
		amanda.showWaitingList();
		
		amanda.nextClientFromQueue().chousePredictiongetAnswer();
		first.showListStory();


		first.setDateOfVisit(new GregorianCalendar(2018, 05, 27));
		first.chousePredictiongetAnswer();
		first.showListStory();
		
		amanda.nextClientFromQueue().chousePredictiongetAnswer();
		second.showListStory();
		amanda.nextClientFromQueue().chousePredictiongetAnswer();
		amanda.nextClientFromQueue().chousePredictiongetAnswer();
		amanda.nextClientFromQueue().chousePredictiongetAnswer();
		System.out.println("");
		amanda.showClientList();

	

		

	}

}
