package db;

public class Connection {

        private static db.Connection thisConnection;
        private Connection() {

        }
        public static db.Connection getConnection() {
            if (thisConnection == null) {
                thisConnection = new Connection();
            }

            return thisConnection;
        }
    }

