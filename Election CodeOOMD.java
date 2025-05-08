import java.util.HashMap;
import java.util.Map;

// Class to represent a political party
class Party {
    private String code;
    private String name;

    public Party(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}

// Class to represent the election result for a constituency
class ConstituencyResult {
    private String constituency;
    private Map<Party, Integer> votes;
    private int totalVotes;

    public ConstituencyResult(String constituency) {
        this.constituency = constituency;
        this.votes = new HashMap<>();
        this.totalVotes = 0;
    }

    public String getConstituency() {
        return constituency;
    }

    public void addVote(Party party, int voteCount) {
        this.votes.put(party, voteCount);
        this.totalVotes += voteCount;
    }

    public Party getWinningParty() {
        Party winningParty = null;
        int maxVotes = -1;
        for (Map.Entry<Party, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winningParty = entry.getKey();
            }
        }
        return winningParty;
    }

    public double getVoteShare(Party party) {
        if (totalVotes == 0 || !votes.containsKey(party)) {
            return 0.0;
        }
        return (double) votes.get(party) / totalVotes * 100;
    }

    public int getTotalVotes() {
        return totalVotes;
    }
}

// Class to manage the election results processing
public class ElectionResultsOOMD {

    private static Map<String, Party> parties = new HashMap<>();

    // Initialize the parties
    static {
        parties.put("BJP", new Party("BJP", "Bhartiya Janta Party"));
        parties.put("INC", new Party("INC", "Indian National Congress"));
        parties.put("BSP", new Party("BSP", "Bahujan Samaj Party"));
        parties.put("CPI", new Party("CPI", "Communist Party of India"));
        parties.put("NCP", new Party("NCP", "Nationalist Congress Party"));
        parties.put("IND", new Party("IND", "Independent"));
    }

    public static void main(String[] args) {
        // Static input data
        String constituencyName = "Jaipur";
        String resultsString = "BJP=400,INC=250,CPI=20,NCP=150";

        // Process the results
        ConstituencyResult result = processConstituencyResult(constituencyName, resultsString);

        // Print the header
        System.out.println("Constituency, Winning Party, Vote Share");

        // Print the result
        printResult(result);
    }

    public static ConstituencyResult processConstituencyResult(String constituencyName, String resultsString) {
        ConstituencyResult result = new ConstituencyResult(constituencyName);
        String[] partyResults = resultsString.split(",");
        for (String partyResult : partyResults) {
            String[] parts = partyResult.split("=");
            if (parts.length != 2) {
                System.out.println("Skipping invalid party result: " + partyResult);
                continue;
            }
            String partyCode = parts[0];
            int voteCount = 0;
            try {
                voteCount = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Skipping invalid vote count: " + parts[1]);
                continue;
            }
            Party party = parties.get(partyCode);
            if (party != null) {
                result.addVote(party, voteCount);
            } else {
                System.out.println("Skipping unknown party code: " + partyCode);
            }
        }
        return result;
    }

    public static void printResult(ConstituencyResult result) {
        if (result.getTotalVotes() > 0) {
            Party winningParty = result.getWinningParty();
            if (winningParty != null) {
                double voteShare = result.getVoteShare(winningParty);
                System.out.printf("%s, %s %s, %.1f%%\n", result.getConstituency(), winningParty.getCode(), winningParty.getName(), voteShare);
            } else {
                System.out.println(result.getConstituency() + ", No winning party found");
            }
        } else {
            System.out.println(result.getConstituency() + ", No votes recorded");
        }
    }
}

