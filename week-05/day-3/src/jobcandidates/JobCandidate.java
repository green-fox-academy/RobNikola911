package jobcandidates;

import java.util.ArrayList;

public class JobCandidate implements Comparable<JobCandidate> {

    private final String name;
    private final String gender;
    private final int age;

    public JobCandidate(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(JobCandidate candidate) {
        return (this.getAge() < candidate.getAge() ? -1 :
                (this.getAge() == candidate.getAge() ? 0 : 1));
    }

  /*@Override
  public int compareTo(JobCandidate candidate) {
    return (this.getName().length() < candidate.getName().length() ? -1 :
            (this.getName().length() == candidate.getName().length() ? 0 : 1));
  }*/

    @Override
    public String toString() {
        return "Name: " + this.name + ", Gender: " + this.gender + ", age:" + this.age +"\n";
    }
}

class Main{
    public static void main(String[] args) {
        JobCandidate j1 = new JobCandidate("John", "male", 25);
        JobCandidate j2 = new JobCandidate("David", "male", 26);
        JobCandidate j3 = new JobCandidate("Honza", "male", 22);
        JobCandidate j4 = new JobCandidate("Lucie", "female", 27);
        JobCandidate j5 = new JobCandidate("Filip", "male", 23);
        JobCandidate j6 = new JobCandidate("Vašek", "male", 28);
        System.out.println(j6.compareTo(j1));

        ArrayList<JobCandidate> candidates = new ArrayList<>();
        candidates.add(j2);
        candidates.add(j1);
        candidates.add(j3);
        candidates.add(j4);
        candidates.add(j5);
        candidates.add(j6);

        JobCandidateSorter s1 = new JobCandidateSorter(candidates);
        System.out.println(s1.getSortedJobCandidateByAge());

    }
}