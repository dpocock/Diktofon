/*
 * Copyright 2013, Institute of Cybernetics at Tallinn University of Technology
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kaljurand_at_gmail_dot_com.diktofon.activity;

import java.io.File;
import java.util.ArrayList;

import kaljurand_at_gmail_dot_com.diktofon.Log;
import kaljurand_at_gmail_dot_com.diktofon.R;
import kaljurand_at_gmail_dot_com.diktofon.Utils;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

// TODO: if the SEND-intent contains a subject then ask the user
// if she wants to turn it into tags
public class RecordingSendActivity extends AbstractDiktofonActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();

		Bundle extras = intent.getExtras();
		if (extras == null) {
			Log.i("ERROR: SEND-intent has no extras");
		} else {
			Log.i("ACTION_SEND: data = " + intent.getData() + ", extras: " + intent.getExtras().keySet());
			if (intent.hasExtra(Intent.EXTRA_STREAM)) {
				Object extraStream = extras.get(Intent.EXTRA_STREAM);
				if (extraStream instanceof Uri) {
					File file = Utils.copyUriToRecordingsDir(this, (Uri) extraStream);
					if (file != null) {
						toast(String.format(getString(R.string.toast_import_audio_uri), file.getAbsolutePath()));
					}
				} else if (extraStream instanceof ArrayList<?>) {
					// TODO: we assume a list of Uris, which might not be the case
					ArrayList<Uri> uris = extras.getParcelableArrayList(Intent.EXTRA_STREAM);
					if (uris != null) {
						toast(String.format(getString(R.string.toast_import_audio_uris), uris.size()));
						for (Uri uri : uris) {
							Utils.copyUriToRecordingsDir(this, uri);
						}
					}
				} else {
					Log.i("ERROR: SEND-intent has EXTRA_STREAM with unsupported content");
				}
			} else {
				Log.i("ERROR: SEND-intent has no EXTRA_STREAM");
			}
		}
		finish();
	}
}