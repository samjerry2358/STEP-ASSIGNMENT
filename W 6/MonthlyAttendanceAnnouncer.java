class GymMember {

    protected String memberId;
    protected int monthlyFee;

    private int sessionsAttended;

    public GymMember(
            String memberId,
            int monthlyFee) {

        if (memberId == null ||
            memberId.trim().length() < 4) {

            throw new IllegalArgumentException(
                "Invalid member ID"
            );
        }

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public void displayInfo() {

        System.out.print(
            "Standard | Sessions: " +
            sessionsAttended
        );
    }
}


class PremiumMember extends GymMember {

    private String trainerName;

    public PremiumMember(
            String memberId,
            int monthlyFee,
            String trainerName) {

        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    @Override
    public void displayInfo() {

        System.out.print(
            "Premium | Trainer: " +
            trainerName +
            " | Sessions: " +
            getSessionsAttended()
        );
    }
}


public class MonthlyAttendanceAnnouncer {

    static String batchPrint(
            GymMember[] members) {

        StringBuilder result =
            new StringBuilder();

        for (GymMember member : members) {

            member.displayInfo();

            // Build the same information using
            // StringBuilder as required.
            if (member instanceof PremiumMember) {

                PremiumMember premium =
                    (PremiumMember) member;

                result.append(
                    "Premium | Trainer: "
                );

                result.append(
                    premium.getTrainerName()
                );

                result.append(
                    " | Sessions: "
                );

                result.append(
                    premium.getSessionsAttended()
                );

                result.append(
                    " [Trainer via downcast: "
                );

                result.append(
                    premium.getTrainerName()
                );

                result.append("] | ");

            } else {

                result.append(
                    "Standard | Sessions: "
                );

                result.append(
                    member.getSessionsAttended()
                );

                result.append(" | ");
            }
        }

        return result.toString();
    }


    public static void main(String[] args) {

        GymMember standard =
            new GymMember(
                "MEM6",
                1000
            );

        PremiumMember premium =
            new PremiumMember(
                "MEM7",
                2000,
                "Coach Riya"
            );

        GymMember[] members = {
            standard,
            premium
        };

        System.out.println(
            batchPrint(members)
        );

        GymMember plain =
            new GymMember(
                "MEM8",
                1000
            );

        // Safe downcast:
        if (plain instanceof PremiumMember) {

            PremiumMember bad =
                (PremiumMember) plain;

            System.out.println(
                bad.getTrainerName()
            );

        } else {

            System.out.println(
                "Downcast avoided: not a PremiumMember"
            );
        }
    }
}