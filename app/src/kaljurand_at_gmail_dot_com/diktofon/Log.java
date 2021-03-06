/*
 * Copyright 2012-2013, Institute of Cybernetics at Tallinn University of Technology
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

package kaljurand_at_gmail_dot_com.diktofon;

public class Log {

	public static final String LOG_TAG = "diktofon";

	private static final boolean DEBUG = false;


	public static void i(String msg) {
		if (DEBUG) android.util.Log.i(LOG_TAG, msg);
	}

	public static void e(String msg) {
		if (DEBUG) android.util.Log.e(LOG_TAG, msg);
	}

	public static void i(String tag, String msg) {
		if (DEBUG) android.util.Log.i(tag, msg);
	}

	public static void e(String tag, String msg) {
		if (DEBUG) android.util.Log.e(tag, msg);
	}
}