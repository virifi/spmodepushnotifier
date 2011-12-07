/*
 * Copyright (C) 2011 virifi
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

package net.virifi.android.spmodepushnotifier;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class WapPushReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle extras = intent.getExtras();
		
		byte[] data = extras.getByteArray("data");
		if (data == null) return;

		Intent i = new Intent("android.provider.Telephony.WAP_PUSH_RECEIVED");
		i.setClassName("jp.co.nttdocomo.carriermail", "jp.co.nttdocomo.carriermail.SMSService");
		i.setType("application/vnd.wap.emn+wbxml");
		i.putExtra("data", data);
		
		context.startService(i);
	}
}
