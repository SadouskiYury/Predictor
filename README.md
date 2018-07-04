FortuneTeller is a class that stores:
 1 a set of fortune-telling and a set of answers for each fortune-telling (LinkedHashMap <Prediction, Queue <Answer>),
 2 The client queue (PriorityQueue <Client>).
 3 Customer accounting (HashMap <Integer, Client>).
  Client - a class that stores the history of calls to the predictor (TreeMap <Date, PredictionResult>). 
   
Client :
 1 can see a list of available predictions;
 2 can turn to the predictor, indicate the purpose of fortune telling, get an answer;
 3 can not apply more often than once a week, if he addresses more often than once a week, or on the date of treatment the predictor limit is exceeded (10 predictions per day), the client enters the waiting list.

Predictor:
 1 Provides the ability to view the list of clients written to the queue;
 2 can remove a client from the waiting list. 
