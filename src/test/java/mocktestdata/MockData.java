package mocktestdata;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MockData {
    private static String[] customerNames=
            {       "customer@bluerentalcars.com",
                    "customer1@bluerentalcars.com",
                    "customer2@bluerentalcars.com",
                    "customer3@bluerentalcars.com"
            };
    private static String[] customerPasswords=
            {       "12345",
                    "12346",
                    "12347",
                    "12348"
            };
    private static String[] cars =
            {
                    "Ford Kuga",
                    "Bugatti Chiron",
                    "BMW Ix3",
                    "Kia Rio",
                    "VW Polo",
                    "Ford Fiesta",
                    "Opel Insigna",
                    "Audi Q8",
                    "Porsche Ceyenne SUV",
                    "Mercedes Vito",
                    "Mercedes glc",
                    "Mercedes G",
                    "audi",
                    "Maseratittt"
            };
    static {

        Random rnd = new Random(System.currentTimeMillis());
        day=rnd.nextInt(30);
        month=rnd.nextInt(11);
        year=2000+rnd.nextInt(10);
        timeFirst=13;
        timeLast=0;
        int ru = rnd.nextInt(3);
        int rc = rnd.nextInt(14);
        MockData.username = customerNames[ru];
        MockData.password = customerPasswords[ru];
        MockData.car = cars[rc];
        MockData.pick_up_place =  shuffle("RandomPlaceName");
        MockData.pickup_date = randomDate(".");
        MockData.pickup_time = randomTime();
        MockData.drop_off_place =  shuffle("RandomPlaceName");
        MockData.dropoff_date = randomDate(".");
        MockData.dropoff_time = randomTime();
        MockData.card_number = shuffle("1234123412341234");
        MockData.card_name = shuffle("RandomName");
        MockData.card_expire_date = randomExpireDate();
        MockData.cvc = shuffle("123");
    }
    private static String username;
    private static String password;
    private static String car;
    private static String pick_up_place;
    private static String drop_off_place;
    private static String pickup_date;
    private static String pickup_time;
    private static String dropoff_date;
    private static String dropoff_time;
    private static String card_number;
    private static String card_name;
    private static String card_expire_date; // MM/YY
    private static String cvc;
    private static int day;
    private static int month;
    private static int year;
    private static int timeFirst=0;
    private static int timeLast=0;

    public static String getUsername() {
        return username;
    }


    public static String getPassword() {
        return password;
    }

    public static String getCar() {
        return car;
    }

    public static String getPick_up_place() {
        return pick_up_place;
    }

    public static String getDrop_off_place() {
        return drop_off_place;
    }

    public static String getPickup_date() {
        return pickup_date;
    }

    public static String getPickup_time() {
        return pickup_time;
    }

    public static String getDropoff_date() {
        return dropoff_date;
    }

    public static String getDropoff_time() {
        return dropoff_time;
    }

    public static String getCard_number() {
        return card_number;
    }

    public static String getCard_name() {
        return card_name;
    }

    public static String getCard_expire_date() {
        return card_expire_date;
    }

    public static String getCvc() {
        return cvc;
    }

    public static void setUsername(String username) {
        MockData.username = username;
    }

    public static void setPassword(String password) {
        MockData.password = password;
    }

    public static void setCar(String car) {
        MockData.car = car;
    }

    public static void setPick_up_place(String pick_up_place) {
        MockData.pick_up_place = pick_up_place;
    }

    public static void setDrop_off_place(String drop_off_place) {
        MockData.drop_off_place = drop_off_place;
    }

    public static void setPickup_date(String pickup_date) {
        MockData.pickup_date = pickup_date;
    }

    public static void setPickup_time(String pickup_time) {
        MockData.pickup_time = pickup_time;
    }

    public static void setDropoff_date(String dropoff_date) {
        MockData.dropoff_date = dropoff_date;
    }

    public static void setDropoff_time(String dropoff_time) {
        MockData.dropoff_time = dropoff_time;
    }

    public static void setCard_number(String card_number) {
        MockData.card_number = card_number;
    }

    public static void setCard_name(String card_name) {
        MockData.card_name = card_name;
    }

    public static void setCard_expire_date(String card_expire_date) {
        MockData.card_expire_date = card_expire_date;
    }

    public static void setCvc(String cvc) {
        MockData.cvc = cvc;
    }
    public static String shuffle(String str){
        List<String> charList = Arrays.stream(str.split("")).collect(Collectors.toList());
        Collections.shuffle(charList);
        return charList.stream().collect(Collectors.joining()).toString();
    }

    public static String randomDate(String  delimiter){
        day++;
        month++;
        year++;
        if (day==30) {
            day=1; month++;
        }
        if (month==12){
            month=1;year++;
        }
        String monthStr = (month<10)?"0"+month:""+month;
        String dayStr = (day<10)?"0"+day:""+day;
        String date = monthStr+delimiter+dayStr+delimiter+year;
        //  MM/DD/YEAR
        return date;
    }

    public static String randomTime(){
        timeFirst++;
        timeLast++;
        if (timeFirst==25){
            timeFirst=13;timeLast++;
        }
        if (timeLast==60){
            timeLast=1;
        }
        String tf = (timeFirst<10)?"0"+timeFirst:""+timeFirst;
        String tl = (timeLast<10)?"0"+timeLast:""+timeLast;

        String time = tf+":"+tl;
        return time;
    }
    public static String randomExpireDate(){
        Random rnd = new Random(System.currentTimeMillis());
        int m = rnd.nextInt(11)+1;
        int y = rnd.nextInt(98)+1;
        String ms = (m<10)?"0"+m:""+m;
        String ys = (y<10)?"0"+y:""+y;
        String expiDate = ms+ys;
        return expiDate;
    }
}