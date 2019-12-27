import redis.clients.jedis.Jedis;

import java.util.List;

public class JavaRedis {
    public static void main(String[] args) {
        //Connecting to Redis server on localhost
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //check si le serveur Redis est connecter ou pas
        System.out.println("Server is running: " + jedis.ping());
        jedis.set("test", "test");
        // print les donnee enregistrer dans la base de donner sous la cle test
        System.out.println("L'enregistrement est :: " + jedis.get("test"));
        //Enregistrer les donne sous forme de liste
        jedis.lpush("SGBD-Nosql-List", "Redis");
        jedis.lpush("SGBD-Nosql-List", "Mongodb");
        jedis.lpush("SGBD-Nosql-List", "Mysql");
        // print de la liste recuperer de REDIS
        List<String> list = jedis.lrange("SGBD-Nosql-List", 0,5);

        for(int i = 0; i < list.size(); i++) {
            System.out.println("SGBD-Item:: " + list.get(i));
        }
    }
} 