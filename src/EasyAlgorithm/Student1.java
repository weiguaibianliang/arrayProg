package EasyAlgorithm;

public class Student1 {
        private int num;
        private String name;
        private double Chinese;
        private double English;
        private double math;
        private double avg;
        public Student1(){

        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getChinese() {
            return Chinese;
        }

        public void setChinese(double chinese) {
            Chinese = chinese;
        }

        public double getEnglish() {
            return English;
        }

        public void setEnglish(double english) {
            English = english;
        }

        public double getMath() {
            return math;
        }

        public void setMath(double math) {
            this.math = math;
        }

        public double getAvg() {
            return avg;
        }

        public void setAvg(double avg) {
            this.avg = avg;
        }

        @Override
        public String toString() {
            return "Student1{" +
                    "num=" + num +
                    ", name='" + name + '\'' +
                    ", Chinese=" + Chinese +
                    ", English=" + English +
                    ", math=" + math +
                    ", avg=" + avg +
                    '}';
        }
    }
