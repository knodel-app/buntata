/*
 * Copyright (c) 2016 Information & Computational Sciences, The James Hutton Institute
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.hutton.ics.knodel.activity;

import android.os.*;
import android.support.design.widget.*;
import android.support.v4.app.*;
import android.support.v4.content.*;

import uk.ac.hutton.ics.knodel.*;
import uk.ac.hutton.ics.knodel.util.*;

/**
 * The {@link DatasourceActivity} contains the {@link uk.ac.hutton.ics.knodel.fragment.DatasourceFragment}. It's used to select the data source.
 *
 * @author Sebastian Raubach
 */
public class DatasourceActivity extends BaseActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.datasource_fragment);
		fragment.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));

		/* Prompt the user to select at least one data source */
		if (!PreferenceUtils.getPreferenceAsBoolean(this, PreferenceUtils.PREFS_AT_LEAST_ONE_DATASOURCE, false))
			SnackbarUtils.show(findViewById(android.R.id.content), R.string.snackbar_select_datasource, Snackbar.LENGTH_LONG);
	}

	@Override
	protected Integer getLayoutId()
	{
		return R.layout.activity_datasource;
	}

	@Override
	protected Integer getToolbarId()
	{
		return R.id.toolbar;
	}

	@Override
	public void onBackPressed()
	{
		int newDatasourceId = PreferenceUtils.getPreferenceAsInt(this, PreferenceUtils.PREFS_SELECTED_DATASOURCE_ID, -1);

		if (newDatasourceId != -1)
			setResult(RESULT_OK);

		super.onBackPressed();
	}
}