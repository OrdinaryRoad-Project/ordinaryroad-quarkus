/*
 * MIT License
 *
 * Copyright (c) 2021 苗锦洲
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package tech.ordinaryroad.commons.mybatis.quarkus.service;


import cn.hutool.core.util.IdUtil;
import tech.ordinaryroad.commons.mybatis.quarkus.model.BaseDO;

/**
 * @author mjz
 * @date 2022/6/12
 */
public interface IFillMetaFieldService {

    /**
     * 创建时生成uuid字段
     *
     * @return String
     */
    default <T extends BaseDO> String generateUuid(T t) {
        // TODO native编译报错
        /**
         * Caused by: com.oracle.graal.pointsto.constraints.UnsupportedFeatureException: Detected an instance of Random/SplittableRandom class in the image heap. Instances created during image generation have cached seed v
         * alues and don't behave as expected.  To see how this object got instantiated use --trace-object-instantiation=java.security.SecureRandom. The object was probably created by a class initializer and is reachable f
         * rom a static field. You can request class initialization at image runtime by using the option --initialize-at-run-time=<class-name>. Or you can write your own initialization methods and call them explicitly from
         *  your main entry point.
         *         at com.oracle.svm.hosted.image.DisallowedImageHeapObjectFeature.error(DisallowedImageHeapObjectFeature.java:173)
         *         at com.oracle.svm.core.image.DisallowedImageHeapObjects.check(DisallowedImageHeapObjects.java:62)
         *         at com.oracle.svm.hosted.image.DisallowedImageHeapObjectFeature.replacer(DisallowedImageHeapObjectFeature.java:149)
         *         at com.oracle.graal.pointsto.meta.AnalysisUniverse.replaceObject(AnalysisUniverse.java:582)
         *         at com.oracle.svm.hosted.ameta.AnalysisConstantReflectionProvider.replaceObject(AnalysisConstantReflectionProvider.java:257)
         *         at com.oracle.svm.hosted.ameta.AnalysisConstantReflectionProvider.interceptValue(AnalysisConstantReflectionProvider.java:228)
         *         at com.oracle.svm.hosted.ameta.AnalysisConstantReflectionProvider.readValue(AnalysisConstantReflectionProvider.java:105)
         *         at com.oracle.svm.hosted.ameta.AnalysisConstantReflectionProvider.readFieldValue(AnalysisConstantReflectionProvider.java:84)
         *         at jdk.internal.vm.compiler/org.graalvm.compiler.nodes.util.ConstantFoldUtil$1.readValue(ConstantFoldUtil.java:55)
         *         at jdk.internal.vm.compiler/org.graalvm.compiler.core.common.spi.JavaConstantFieldProvider.readConstantField(JavaConstantFieldProvider.java:84)
         *         at com.oracle.svm.hosted.ameta.AnalysisConstantFieldProvider.readConstantField(AnalysisConstantFieldProvider.java:72)
         *         at jdk.internal.vm.compiler/org.graalvm.compiler.nodes.util.ConstantFoldUtil.tryConstantFold(ConstantFoldUtil.java:51)
         *         at com.oracle.svm.hosted.phases.ConstantFoldLoadFieldPlugin.tryConstantFold(ConstantFoldLoadFieldPlugin.java:61)
         *         at com.oracle.svm.hosted.phases.ConstantFoldLoadFieldPlugin.handleLoadStaticField(ConstantFoldLoadFieldPlugin.java:57)
         *         at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.genGetStatic(BytecodeParser.java:4747)
         *         at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.genGetStatic(BytecodeParser.java:4718)
         *         at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.processBytecode(BytecodeParser.java:5212)
         *         at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.iterateBytecodesForBlock(BytecodeParser.java:3358)
         *         at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.handleBytecodeBlock(BytecodeParser.java:3318)
         *         at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.processBlock(BytecodeParser.java:3163)
         *         at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.build(BytecodeParser.java:1138)
         *         at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.buildRootMethod(BytecodeParser.java:1030)
         *         at jdk.internal.vm.compiler/org.graalvm.compiler.java.GraphBuilderPhase$Instance.run(GraphBuilderPhase.java:84)
         *         at com.oracle.svm.hosted.phases.SharedGraphBuilderPhase.run(SharedGraphBuilderPhase.java:79)
         *         at jdk.internal.vm.compiler/org.graalvm.compiler.phases.Phase.run(Phase.java:49)
         *         at jdk.internal.vm.compiler/org.graalvm.compiler.phases.BasePhase.apply(BasePhase.java:236)
         *         at jdk.internal.vm.compiler/org.graalvm.compiler.phases.Phase.apply(Phase.java:42)
         *         at jdk.internal.vm.compiler/org.graalvm.compiler.phases.Phase.apply(Phase.java:38)
         *         at com.oracle.graal.pointsto.flow.AnalysisParsedGraph.parseBytecode(AnalysisParsedGraph.java:135)
         *         at com.oracle.graal.pointsto.meta.AnalysisMethod.ensureGraphParsed(AnalysisMethod.java:586)
         *         at com.oracle.graal.pointsto.flow.MethodTypeFlowBuilder.parse(MethodTypeFlowBuilder.java:166)
         *         at com.oracle.graal.pointsto.flow.MethodTypeFlowBuilder.apply(MethodTypeFlowBuilder.java:357)
         *         at com.oracle.graal.pointsto.flow.MethodTypeFlow.createTypeFlow(MethodTypeFlow.java:301)
         *         at com.oracle.graal.pointsto.flow.MethodTypeFlow.ensureTypeFlowCreated(MethodTypeFlow.java:290)
         *         at com.oracle.graal.pointsto.flow.MethodTypeFlow.addContext(MethodTypeFlow.java:111)
         *         at com.oracle.graal.pointsto.flow.StaticInvokeTypeFlow.update(InvokeTypeFlow.java:388)
         *         at com.oracle.graal.pointsto.PointsToAnalysis$1.run(PointsToAnalysis.java:631)
         *         at com.oracle.graal.pointsto.util.CompletionExecutor.executeCommand(CompletionExecutor.java:193)
         *         at com.oracle.graal.pointsto.util.CompletionExecutor.lambda$executeService$0(CompletionExecutor.java:177)
         *         at java.base/java.util.concurrent.ForkJoinTask$RunnableExecuteAction.exec(ForkJoinTask.java:1426)
         *         at java.base/java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:290)
         *         at java.base/java.util.concurrent.ForkJoinPool$WorkQueue.topLevelExec(ForkJoinPool.java:1020)
         *         at java.base/java.util.concurrent.ForkJoinPool.scan(ForkJoinPool.java:1656)
         *         at java.base/java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1594)
         *         at java.base/java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:183)
         * ------------------------------------------------------------------------------------------------------------------------
         *                        12.9s (10.4% of total time) in 25 GCs | Peak RSS: 6.86GB | CPU load: 5.14
         * ========================================================================================================================
         * Failed generating 'ordinaryroad-blog-quarkus-1.0-SNAPSHOT-runner' after 2m 2s.
         * Error: Image build request failed with exit status 1
         * [INFO] ------------------------------------------------------------------------
         * [INFO] BUILD FAILURE
         * [INFO] ------------------------------------------------------------------------
         * [INFO] Total time:  03:07 min
         * [INFO] Finished at: 2022-08-01T22:34:24+08:00
         * [INFO] ------------------------------------------------------------------------
         * [ERROR] Failed to execute goal io.quarkus.platform:quarkus-maven-plugin:2.10.1.Final:build (default) on project ordinaryroad-blog-quarkus: Failed to build quarkus application: io.quarkus.builder.BuildException:
         * Build failure: Build failed due to errors
         * [ERROR]         [error]: Build step io.quarkus.deployment.pkg.steps.NativeImageBuildStep#build threw an exception: io.quarkus.deployment.pkg.steps.NativeImageBuildStep$ImageGenerationFailureException: Image gene
         * ration failed. Exit code: 1
         * [ERROR]         at io.quarkus.deployment.pkg.steps.NativeImageBuildStep.imageGenerationFailed(NativeImageBuildStep.java:400)
         * [ERROR]         at io.quarkus.deployment.pkg.steps.NativeImageBuildStep.build(NativeImageBuildStep.java:240)
         * [ERROR]         at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
         * [ERROR]         at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
         * [ERROR]         at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
         * [ERROR]         at java.base/java.lang.reflect.Method.invoke(Method.java:566)
         * [ERROR]         at io.quarkus.deployment.ExtensionLoader$3.execute(ExtensionLoader.java:944)
         * [ERROR]         at io.quarkus.builder.BuildContext.run(BuildContext.java:277)
         * [ERROR]         at org.jboss.threads.ContextHandler$1.runWith(ContextHandler.java:18)
         * [ERROR]         at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2449)
         * [ERROR]         at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1478)
         * [ERROR]         at java.base/java.lang.Thread.run(Thread.java:834)
         * [ERROR]         at org.jboss.threads.JBossThread.run(JBossThread.java:501)
         * [ERROR] -> [Help 1]
         * [ERROR]
         * [ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
         * [ERROR] Re-run Maven using the -X switch to enable full debug logging.
         * [ERROR]
         * [ERROR] For more information about the errors and possible solutions, please read the following articles:
         * [ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException
         */
        // return IdUtil.simpleUUID();
        return IdUtil.getSnowflake().nextIdStr();
    }

    /**
     * 创建时生成CreateBy字段
     *
     * @return String
     */
    String generateCreateBy();

    /**
     * 更新时生成UpdateBy字段
     *
     * @return String
     */
    String generateUpdateBy();

}
