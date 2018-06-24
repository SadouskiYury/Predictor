package by.htp.predictor.run;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import by.htp.predictor.been.Answer;
import by.htp.predictor.been.Client;
import by.htp.predictor.been.FortuneTeller;
import by.htp.predictor.been.Prediction;

/*
 * “Предсказатель”
 * 
 * Реализовать программу, которая позволяет предсказывать пользователю вариант
 * развития различных ситуаций. Предсказатель (FortuneTeller) - класс, у
 * которого хранится: набор гаданий и набор ответов для каждого гадания
 * (LinkedHashMap<Prediction, Queue<Answer>);
 * 
 * предсказатель ведёт учёт клиентов (HashMap<Date, Client>); предсказатель
 * предоставляет возможность просмотра списка клиентов, записанных в очередь на
 * приём; предсказатель имеет возможность удалять клиента из списка ожидания.
 *
 * очередь клиентов (PriorityQueue<Client>). Если клиент обращается чаще одного
 * раза в неделю, либо на дату обращения превышен лимит предсказателя (не более
 * 10 предсказаний в сутки), клиент попадает в лист ожидания; Реализовать
 * следующие функциональные возможности: клиент может просмотреть список
 * доступных предсказаний; клиент может обратиться к предсказателю, указать цель
 * гадания, получить ответ. клиент хранит историю обращений к предсказателю
 * (TreeMap <Date, PredictionResult> ) PredictionResult = Prediction + Answer.
 * 
 * 
 */
public class PredictionResult {

	public static void main(String[] args) {

//		Date date = new Date();
////		System.out.println(date.getMonth());
////		System.out.println(date.getDate());
////		System.out.println(date.toString());
//		Date four = new Date(118, 05, 25);
//		Date w = new Date(118, 05, 24);
////		Date tree = new Date(118, 05, 24);
////		Date five = new Date(118, 05, 25);
////		System.out.println(tree.toString());
//		System.out.println(w.compareTo(four));
//		System.out.println(date.getDate());
////		System.out.println(date.compareTo(tree));
////		System.out.println(date.compareTo(five));
////		System.out.println();

		FortuneTeller amanda = new FortuneTeller("Amanda", 25.00);
		// amanda.showPredictions();
		Client first = new Client("Vasya", "Petrov", new Date(118, 05, 24));
		Client second = new Client("Marina", "Kuzmena", new Date(118, 05, 24));
		Client third = new Client("Volodya", "Klimov", new Date(118, 05, 24));
	//	first.setDateOfVisit(new Date(118, 05, 28));
		
		amanda.joinQueueClient(first);
		amanda.joinQueueClient(second);
		amanda.joinQueueClient(third);

		
		System.out.println(amanda.getPriorityQueue().toString());
		System.out.println(amanda.getWaitingList().toString());
	
		
		Answer ans = amanda.nextClientFromQueue().chousePredictiongetAnswer();
		System.out.println(first.showListStory());
		Answer two = amanda.nextClientFromQueue().chousePredictiongetAnswer();
		System.out.println(second.showListStory());
//
//		Answer two = first.chousePredictiongetAnswer();
	
		System.out.println(amanda.getPriorityQueue().toString());
	
		// System.out.println(n.toString());

	}

}
