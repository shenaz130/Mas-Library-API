package lk.shenaz.maslibrary;

public class User {
        private String Email;
        private String UserName;
        private int password;
        private String Gender;


        public User(){

        }

        public String getEmail(){
            return Email;
        }

        public void setEmail(String Email){
            this.Email=Email;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String userName) {
            UserName = userName;
        }

        public int getPassword() {
            return password;
        }

        public void setPassword(int password) {
            this.password = password;
        }

        public String getGender() {
            return Gender;
        }

        public void setGender(String gender) {
            Gender = gender;
        }
}
