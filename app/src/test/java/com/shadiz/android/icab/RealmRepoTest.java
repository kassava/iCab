package com.shadiz.android.icab;

import com.shadiz.android.icab.dagger.Injector;
import com.shadiz.android.icab.dagger.application.AppComponentTest;
import com.shadiz.android.icab.dagger.application.AppModuleTest;
import com.shadiz.android.icab.dagger.realm.RealmRepoModuleTest;
import com.shadiz.android.icab.data.repositories.RealmRepo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created on 01.02.2017.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(application = CustomAppTest.class, constants = BuildConfig.class ,sdk = 23)
@PowerMockIgnore({"org.robolectric.*", "android.*"})
@PrepareForTest({Realm.class, Injector.class, RealmQuery.class, RealmResults.class})
public class RealmRepoTest {

    Realm realmMock;

    @Inject
    RealmRepo repo;

    @Rule
    public PowerMockRule rule = new PowerMockRule();

    @Before
    public void setupRealm() {
        AppComponentTest appComponentTest = DaggerAppComponentTest.builder()
                .appModuleTest(new AppModuleTest())
                .realmRepoModuleTest(new RealmRepoModuleTest())
                .build();

        mockStatic(Injector.class);
        when(Injector.getAppComponent()).thenReturn(appComponentTest);

        ((AppComponentTest) Injector.getAppComponent()).inject(this);

        realmMock = mock(Realm.class);
        mockStatic(Realm.class);
        when(Realm.getDefaultInstance()).thenReturn(realmMock);
    }

    @Test
    public void shouldBeAbleToGetDefaultInstance() {
        assertThat(Realm.getDefaultInstance(), is(realmMock));
    }

    @Test
    public void removeClientObject() throws Exception {

    }

    @Test
    public void resetClientStartInfo() throws Exception {

    }

    @Test
    public void setClientKey() throws Exception {
//        repo.setClientKey(RealmFieldsTable.RealmClientModel.LAST_SELECTED_DRIVER, "basd");

//        assertThat(repo.getClientKey(RealmFieldsTable.RealmClientModel.LAST_SELECTED_DRIVER))
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
        realmMock.close();
    }
}