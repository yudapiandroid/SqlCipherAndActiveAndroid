package com.activeandroid;

/*
 * Copyright (C) 2010 Michael Pardo
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

import android.content.Context;

import com.activeandroid.util.Log;

import net.sqlcipher.database.SQLiteDatabase;

public final class ActiveAndroid {
	//////////////////////////////////////////////////////////////////////////////////////
	// PUBLIC METHODS
	//////////////////////////////////////////////////////////////////////////////////////

	public static String password;

	public static void initialize(Context context,String password) {
		initialize(new Configuration.Builder(context).create(),password);
	}

	public static void initialize(Configuration configuration,String password) {
		initialize(configuration, false,password);

	}

	public static void initialize(Context context, boolean loggingEnabled,String password) {
		initialize(new Configuration.Builder(context).create(), loggingEnabled,password);
	}

	public static void initialize(Configuration configuration, boolean loggingEnabled,String password) {
		// Set logging enabled first
		SQLiteDatabase.loadLibs(configuration.getContext());
		ActiveAndroid.password = password;
		setLoggingEnabled(loggingEnabled);
		Cache.initialize(configuration);
	}

	public static void clearCache() {
		Cache.clear();
	}

	public static void dispose() {
		Cache.dispose();
	}

	public static void setLoggingEnabled(boolean enabled) {
		Log.setEnabled(enabled);
	}

	public static SQLiteDatabase getDatabase() {
		return Cache.openDatabase();
	}

	public static void beginTransaction() {
		Cache.openDatabase().beginTransaction();
	}

	public static void endTransaction() {
		Cache.openDatabase().endTransaction();
	}

	public static void setTransactionSuccessful() {
		Cache.openDatabase().setTransactionSuccessful();
	}

	public static boolean inTransaction() {
		return Cache.openDatabase().inTransaction();
	}

	public static void execSQL(String sql) {
		Cache.openDatabase().execSQL(sql);
	}

	public static void execSQL(String sql, Object[] bindArgs) {
		Cache.openDatabase().execSQL(sql, bindArgs);
	}
}
