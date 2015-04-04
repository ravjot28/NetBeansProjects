d.xml file. -->
    </target>
    <target depends="init,compile,-pre-pre-compile-test,-pre-compile-test-single,-do-compile-test-single,-post-compile-test-single" name="compile-test-single"/>
    <!--
                =======================
                JUNIT EXECUTION SECTION
                =======================
            -->
    <target depends="init" if="have.tests" name="-pre-test-run">
        <mkdir dir="${build.test.results.dir}"/>
    </target>
    <target depends="init,compile-test,-pre-test-run" if="have.tests" name="-do-test-run">
        <j2seproject3:junit testincludes="**/*Test.java"/>
    </target>
    <target depends="init,compile-test,-pre-test-run,-do-test-run" if="have.tests" name="-post-test-run">
        <fail if="tests.failed" unless="ignore.failing.tests">Some tests failed; see details above.</fail>
    </target>
    <target depends="init" if="have.tests" name="test-report"/>
    <target depends="init" if="netbeans.home+have.tests" name="-test-browse"/>
    <target depends="init,compile-test,-pre-test-run,-do-test-run,test-report,-post-test-run,-test-browse" description="Run unit tests." name="test"/>
    <target depends="init" if="have.tests" name="-pre-test-run-single">
        <mkdir dir="${build.test.results.dir}"/>
    </target>
    <target depends="init,compile-test-single,-pre-test-run-single" if="have.tests" name="-do-test-run-single">
        <fail unless="test.includes">Must select some files in the IDE or set test.includes</fail>
        <j2seproject3:junit excludes="" includes="${test.includes}"/>
    </target>
    <target depends="init,compile-test-single,-pre-test-run