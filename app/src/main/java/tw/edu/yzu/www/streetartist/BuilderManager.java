package tw.edu.yzu.www.streetartist;

import com.nightonke.boommenu.BoomButtons.HamButton;

/**
 * Created by 阿賢賢 on 2016/12/25.
 */

public class BuilderManager {
    static HamButton.Builder getHamButtonBuilder() {
        return new HamButton.Builder()
                .normalTextRes(R.string.text_ham_button_text_normal)
                .subNormalTextRes(R.string.text_ham_button_sub_text_normal);
    }
    private static BuilderManager ourInstance = new BuilderManager();

    public static BuilderManager getInstance() {
        return ourInstance;
    }

    private BuilderManager() {
    }
}
