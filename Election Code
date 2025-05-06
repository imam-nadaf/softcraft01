import java.util.HashMap;
import java.util.Map;

public class ElectionResultsStatic {

    public static void processConstituencyResult(String constituency, String resultsString) {
        try {

            Map<String, Integer> votes = new HashMap<>();
            int totalVotes = 0;

            String[] partyResults = resultsString.split(",");

            for (String partyResult : partyResults) {
                String[] partyVotes = partyResult.split("=");
                if (partyVotes.length != 2) {
                    System.out.println("Skipping invalid party result: " + partyResult);
                    continue;
                }
                String partyCode = partyVotes[0];
        
                    int voteCount = Integer.parseInt(partyVotes[1]);
                    votes.put(partyCode, voteCount);
                    totalVotes += voteCount;
            }

            String winningParty = null;
            int maxVotes = -1;
            for (Map.Entry<String, Integer> entry : votes.entrySet()) {
                if (entry.getValue() > maxVotes) {
                    maxVotes = entry.getValue();
                    winningParty = entry.getKey();
                }
            }

            if (winningParty != null && totalVotes > 0) {
                double voteShare = (double) maxVotes / totalVotes * 100;
                System.out.printf("%s, %s %.1f%%\n", constituency, winningParty, voteShare);
            } else if (totalVotes == 0) {
                System.out.println(constituency + ", No votes recorded");
            }
            else {
                System.out.println(constituency + ", No winning party found");
            }
        } catch (Exception e) {
            System.out.println("Error processing data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String constituency = "Jaipur";
        String resultsString = "BJP=400,INC=250,CPI=20,NCP=150";

        System.out.println("Constituency, Winning Party, Vote Share");
        processConstituencyResult(constituency, resultsString);
    }
}

