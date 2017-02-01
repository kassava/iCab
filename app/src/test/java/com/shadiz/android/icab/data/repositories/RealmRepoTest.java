package com.shadiz.android.icab.data.repositories;

import com.shadiz.android.icab.BuildConfig;
import com.shadiz.android.icab.data.realm.table.RealmTable;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import io.realm.Realm;
import io.realm.log.RealmLog;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created on 01.02.2017.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 19)
@PowerMockIgnore({"org.mockito.*", "org.robolectric.*", "android.*"})
@SuppressStaticInitializationFor("io.realm.internal.Util")
@PrepareForTest({Realm.class, RealmLog.class})
public class RealmRepoTest {

    private Realm mockRealm;
    private RealmRepo repo;

    @Rule
    public PowerMockRule rule = new PowerMockRule();

    @Before
    public void setUp() throws Exception {
        mockStatic(RealmLog.class);
        mockStatic(Realm.class);

        Realm mockRealm = PowerMockito.mock(Realm.class);

        when(Realm.getDefaultInstance()).thenReturn(mockRealm);

//        repo = new RealmRepo(context);
    }

    @Test
    public void shouldBeAbleToGetDefaultInstance() {
        assertThat(Realm.getDefaultInstance(), is(mockRealm));
    }

    @Test
    public void removeClientObject() throws Exception {

    }

    @Test
    public void resetClientStartInfo() throws Exception {

    }

    @Test
    public void setClientKey() throws Exception {
        repo.setClientKey(RealmTable.RealmClientModel.LAST_SELECTED_DRIVER, "basd");

//        assertThat(repo.getClientKey(RealmTable.RealmClientModel.LAST_SELECTED_DRIVER))
//                .isEqualTo("basd");
    }

    @Test
    public void getClientKey() throws Exception {

    }

    @Test
    public void setLatLngGeoCode() throws Exception {

    }

    @Test
    public void getLatLng() throws Exception {

    }

    @Test
    public void setPickClientLatLng() throws Exception {

    }

    @Test
    public void getPickClientLatLng() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        mockRealm.close();
    }

}