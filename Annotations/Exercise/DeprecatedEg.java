package Exercise;
class LegacyAPI {
    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old feature. It is deprecated.");
    }
    public void newFeature() {
        System.out.println("This is the new feature. Use this instead.");
    }
}
public class DeprecatedEg {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();
        api.newFeature();
    }
}
