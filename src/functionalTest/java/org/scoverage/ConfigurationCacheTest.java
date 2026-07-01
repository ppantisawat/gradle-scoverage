package org.scoverage;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

public class ConfigurationCacheTest extends ScoverageFunctionalTest {

    public ConfigurationCacheTest() {
        super("scala-single-module");
    }

    @Override
    protected List<String> getVersionAgruments() {
        return ScalaVersionArguments.version2;
    }

    @Test
    @Ignore("Enabled once configuration cache support is implemented")
    public void checkScoverageStoresAndReusesConfigurationCache() throws Exception {

        runWithConfigurationCache("clean", ScoveragePlugin.getCHECK_NAME());
        AssertableBuildResult secondRun = runWithConfigurationCache(ScoveragePlugin.getCHECK_NAME());

        secondRun.assertConfigurationCacheReused();
        secondRun.assertTaskSucceeded(ScoveragePlugin.getCHECK_NAME());
        assertCoverage(50.0);
    }
}
