import java.util.HashMap;
import java.util.Map;

// 1. Party Class
class Party {
    String code;
    String name;

    public Party(String code, String name) {
        this.code = code;
        this.name = name;
    }
}

// 2. Result Class
class Result {
    String areaName;
    Map<Party, Integer> partyVotes;

    public Result(String areaName) {
        this.areaName = areaName;
        this.partyVotes = new HashMap<>();
    }

    public void addVotes(Party party, int votes) {
        this.partyVotes.put(party, votes);
    }

    public Party getWinner() {
        Party winner = null;
        int maxVotes = -1;
        for (Map.Entry<Party, Integer> entry : partyVotes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        return winner;
    }

    public double getWinnerPercentage() {
        if (partyVotes.isEmpty()) return 0;
        int totalVotes = 0;
        for (int votes : partyVotes.values()) {
            totalVotes += votes;
        }
        if (totalVotes == 0) return 0;
        return (double) partyVotes.get(getWinner()) / totalVotes * 100;
    }

    public void printResult() {
        Party winner = getWinner();
        double percentage = getWinnerPercentage();
        System.out.println(areaName + ": " + winner.name + " (" + winner.code + "), " + String.format("%.1f", percentage) + "%");
    }
}

// 3. Main class
public class Main {

    public static void main(String[] args) {
     
        Party bjp = new Party("BJP", "Bhartiya Janta Party");
        Party inc = new Party("INC", "Indian National Congress");
        Party cpi = new Party("CPI", "Communist Party of India");
        Party ncp = new Party("NCP", "Nationalist Congress Party");
        Party ind = new Party("IND", "Independent");


       
        Result electionResult1 = new Result("Jaipur "); 
        electionResult1.addVotes(bjp, 400);
        electionResult1.addVotes(inc, 250);
        electionResult1.addVotes(cpi, 20);
        electionResult1.addVotes(ncp, 150);

      
        System.out.println("Election Results:");
        electionResult1.printResult();
    }
}
