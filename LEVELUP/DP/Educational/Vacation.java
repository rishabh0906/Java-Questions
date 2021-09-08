public class Vacation {

    public static int[] MaxScore(int[][] activities, int idx) {

        if (idx == activities.length - 1) {

            return new int[] { activities[idx][0], activities[idx][1], activities[idx][2] };
        }

        int[] myAns = new int[3];

        int[] ans = MaxScore(activities, idx + 1);

        myAns[0] = activities[idx][0] + Math.max(ans[1], ans[2]);
        myAns[1] = activities[idx][1] + Math.max(ans[0], ans[2]);
        myAns[2] = activities[idx][2] + Math.max(ans[0], ans[1]);

        return myAns;

    }

    public static void main(String[] args) {

        

        int[][] activities = { { 6, 7, 8 }, { 8, 8, 3 }, { 2, 5, 2 }, { 7, 8, 6 }, { 4, 6, 8 }, { 2, 3, 4 },
                { 7, 5, 1 } };
        int[] ans = MaxScore(activities, 0);
        System.out.println(Math.max(ans[0], Math.max(ans[1], ans[2])));

    }
}
