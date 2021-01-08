package producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import model.UserData;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Producer {

    private final static String EXCHANGE_NAME = "documents";
    private final static String EXCHANGE_TYPE = "fanout";

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");

        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();

                channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE);

            ObjectMapper objectMapper = new ObjectMapper();
            UserData userData = getData();
            byte[] bytes = objectMapper.writeValueAsBytes(userData);

                channel.basicPublish(EXCHANGE_NAME, "",null, bytes);
        } catch (IOException | TimeoutException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static UserData getData() {
        Scanner in = new Scanner(System.in);

        String name;
        String surname;
        String passportNumber;
        String age;
        Date issueDate = new Date();

        System.out.println("Введите Ваше имя");
        name = in.nextLine();
        System.out.println("Введите Вашу фамилию");
        surname = in.nextLine();
        System.out.println("Введите Номер Паспорта");
        passportNumber = in.nextLine();
        System.out.println("Введите Ваш возраст");
        age = in.nextLine();
        System.out.println("Введите дату выдачи");
        System.out.println("День");
        issueDate.setDate(in.nextInt());
        System.out.println("Месяц");
        issueDate.setMonth(in.nextInt());
        System.out.println("Год");
        issueDate.setYear(in.nextInt());

        return UserData.builder()
                .name(name)
                .surname(surname)
                .passportNumber(passportNumber)
                .age(age)
                .issueDate(issueDate)
                .build();
    }

}