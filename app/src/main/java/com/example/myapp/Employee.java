package com.example.myapp;

public class Employee {


        public static void main(String[] args) {
            Employee tester = new Employee(7,"Developer");
            System.out.println(tester.getId());
            System.out.println(tester.getVacancy());
        }


        private long id;
        private Vacancy vacancy;
        // добавим конструктор
        public Employee(int id , String v ) {
            this.id=id;
            this.vacancy=new Vacancy(v);
        }
        String getVacancy() {
            return vacancy.getVacancy();
        }

        long getId() {
            return id;
        }


        class Vacancy {
            String position;
            // добавим конструктор
            public	Vacancy(String p) {
                this. position=p;
            }

            String getVacancy() {
                return  this. position;

            }
        }



    }

