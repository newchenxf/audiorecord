package com.chenxf.audiorecord;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.chenxf.audiorecord.entity.EnterRecordAudioEntity;
import com.chenxf.audiorecord.ui.AudioRecordActivity;

/**
 * Created by chenxf on 17-7-6.
 */

public class AudioRecordJumpUtil {

    /**
     * 跳转录制语音页面
     */
    public static void startRecordAudio(Context context) {
        EnterRecordAudioEntity entity = new EnterRecordAudioEntity();
        entity.setSourceType(EnterRecordAudioEntity.SourceType.AUDIO_FEED);

        Intent intent = new Intent(context, AudioRecordActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(AudioRecordActivity.KEY_ENTER_RECORD_AUDIO_ENTITY, entity);
        intent.putExtra(AudioRecordActivity.KEY_AUDIO_BUNDLE, bundle);
        context.startActivity(intent);
    }
}
