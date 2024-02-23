public class Input {
    private String grapeQuality; // качество винограда
    private String storage; // хранение
    private String alcoholPercentage; // процент алкоголя
    private String regionRating; // рейтинг региона
    private double balance; // баланс вкусовых характеристик
    private String excerpt; // выдержка вина
    private String sugar; // сахар
    private String spin; //отжим сока

    public Input(
            String grapeQuality,
            String storage,
            String alcoholPercentage,
            String regionRating,
            double balance,
            String excerpt,
            String sugar,
            String spin
    ) {
        this.grapeQuality = grapeQuality;
        this.storage = storage;
        this.alcoholPercentage = alcoholPercentage;
        this.regionRating = regionRating;
        this.balance = balance;
        this.excerpt = excerpt;
        this.sugar = sugar;
        this.spin = spin;
    }

    public double[] toConvert() {
        double[] res = new double[8];


        if ("низкое".equals(this.grapeQuality)) res[0] = 0;
        else if ("среднее".equals(this.grapeQuality)) res[0] = 0.5;
        else res[0] = 1;

        if ("бочка".equals(this.storage)) res[1] = 1;
        else res[1] = 0;

        if ("крепленое".equals(this.alcoholPercentage)) res[2] = 1;
        else res[2] = 0;

        if ("низкий".equals(this.regionRating)) res[3] = 0;
        else if ("средний".equals(this.regionRating)) res[3] = 0.5;
        else res[3] = 1;

        res[4] = this.balance / 100;

        if ("0-1".equals(this.excerpt)) res[5] = 0;
        else if ("1-4".equals(this.excerpt)) res[5] = 0.25;
        else if ("4-10".equals(this.excerpt)) res[5] = 0.75;
        else res[5] = 1;

        if ("нет".equals(this.sugar)) res[6] = 1;
        else res[6] = 0;

        if ("вручную".equals(this.spin)) res[7] = 1;
        else res[7] = 0;

        return res;
    }
}