package com.chenxf.audiorecord.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.chenxf.audiorecord.AudioPlaybackManager;
import com.chenxf.audiorecord.AudioRecordJumpUtil;
import com.chenxf.audiorecord.R;
import com.chenxf.audiorecord.entity.AudioEntity;
import com.chenxf.audiorecord.eventbus.EventBusConfig;
import com.chenxf.audiorecord.eventbus.MainThreadEvent;
import com.chenxf.audiorecord.ui.view.CommonSoundItemView;
import com.chenxf.audiorecord.util.PPLog;
import com.chenxf.audiorecord.util.PaoPaoTips;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;

/**
 * Created by chenxf on 17-7-14.
 */

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private ImageView ivAbandonSound;
    private CommonSoundItemView soundItemView;
    private RelativeLayout recordBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PPLog.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        EventBus.getDefault().register(this);
    }

    private void findView() {
        ivAbandonSound = (ImageView) findViewById(R.id.pp_iv_abandon_sound);
        ivAbandonSound.setOnClickListener(this);
        soundItemView = (CommonSoundItemView) findViewById(R.id.pp_sound_item_view);
        recordBtn = (RelativeLayout) findViewById(R.id.rl_sound);
        recordBtn.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    /**
     * EventBus监听
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MainThreadEvent mainThreadEvent) {
        if(mainThreadEvent.getWhat() == EventBusConfig.SOUND_FEED_RECORD_FINISH) {
            Object soundPath = mainThreadEvent.getObj();
            if (soundPath != null && soundPath instanceof String) {
                String path = (String) soundPath;
                AudioEntity entity = new AudioEntity();
                entity.setUrl(path);
                int duration = AudioPlaybackManager.getDuration(path);
                if (duration <= 0) {
                    PPLog.d(TAG, "duration <= 0");
                    PaoPaoTips.showDefault(this, "无权限");

                    File tempFile = new File(path);
                    if (tempFile.exists()) {
                        tempFile.delete();
                        return;
                    }
                } else {
                    entity.setDuration(duration / 1000);
                    soundItemView.setSoundData(entity);
                    soundItemView.setVisibility(View.VISIBLE);
                    ivAbandonSound.setVisibility(View.VISIBLE);
                    recordBtn.setVisibility(View.INVISIBLE);
                    PPLog.d(TAG, "soundPath:" + path);
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.pp_iv_abandon_sound) {
            abandonSound();
        } else if(v.getId() == R.id.rl_sound) {
            AudioRecordJumpUtil.startRecordAudio(MainActivity.this);
        }
    }

    private void abandonSound() {
        soundItemView.clearData();
        soundItemView.setVisibility(View.GONE);
        ivAbandonSound.setVisibility(View.GONE);
        recordBtn.setVisibility(View.VISIBLE);
    }
}
