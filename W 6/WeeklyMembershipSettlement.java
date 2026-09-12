class GymMember {

    private static int memberCounter = 2000;

    private final String membershipNumber;

    private int monthlyFee;
    private int feesPaid;

    public GymMember(int monthlyFee) {

        memberCounter++;

        membershipNumber =
            "GYM-" + memberCounter;

        this.monthlyFee = monthlyFee;
        this.feesPaid = 0;
    }

    public void payFee(int amount) {

        feesPaid += amount;
    }

    public void payFee(
            int amount,
            String mode) {

        System.out.println(
            "Payment Mode: " + mode
        );

        payFee(amount);
    }

    public int getFeesPaid() {

        return feesPaid;
    }

    public static boolean isValidReferralCode(
            String code) {

        if (code == null ||
            code.length() != 4) {

            return false;
        }

        if (code.charAt(0) != 'G') {
            return false;
        }

        if (!Character.isDigit(
                code.charAt(1))) {

            return false;
        }

        if (!Character.isDigit(
                code.charAt(2))) {

            return false;
        }

        if (!Character.isUpperCase(
                code.charAt(3))) {

            return false;
        }

        return true;
    }

    public static int getMembersEnrolled() {

        return memberCounter - 2000;
    }

    public String getMembershipNumber() {

        return membershipNumber;
    }
}


class GroupClassMember extends GymMember {

    private String className;

    public GroupClassMember(
            int monthlyFee,
            String className) {

        super(monthlyFee);
        this.className = className;
    }
}


public class WeeklyMembershipSettlement {

    static String processWeeklyCheckIn(
            GymMember[] members) {

        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        for (GymMember member : members) {

            if (member == null) {

                nullSkipped++;
                continue;
            }

            processed++;

            if (member instanceof GroupClassMember) {

                group++;

            } else {

                individual++;
            }
        }

        return processed +
               " processed | " +
               nullSkipped +
               " null skipped | " +
               group +
               " group | " +
               individual +
               " individual";
    }


    public static void main(String[] args) {

        GymMember m1 =
            new GymMember(1000);

        System.out.println(
            m1.getMembershipNumber()
        );

        System.out.println(
            GymMember.getMembersEnrolled()
        );

        System.out.println(
            GymMember.isValidReferralCode(
                "G45B"
            )
        );

        System.out.println(
            GymMember.isValidReferralCode(
                "G4B"
            )
        );

        System.out.println(
            GymMember.isValidReferralCode(
                "X45B"
            )
        );

        m1.payFee(500);

        m1.payFee(
            500,
            "UPI"
        );

        System.out.println(
            m1.getFeesPaid()
        );

        GymMember[] members = {

            new GroupClassMember(
                1500,
                "Zumba"
            ),

            null,

            new GymMember(1000)
        };

        System.out.println(
            processWeeklyCheckIn(
                members
            )
        );
    }
}