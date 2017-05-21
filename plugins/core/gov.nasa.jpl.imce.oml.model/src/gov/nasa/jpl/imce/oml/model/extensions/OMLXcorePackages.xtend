/**
 * 
 * Copyright 2017 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
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
 * 
 */
package gov.nasa.jpl.imce.oml.model.extensions

import gov.nasa.jpl.imce.oml.model.common.CommonPackage
import java.nio.file.Path
import java.nio.file.Paths
import java.util.Map
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.plugin.EcorePlugin
import org.eclipse.emf.ecore.xcore.XcorePackage
import org.eclipse.emf.ecore.xcore.XcoreStandaloneSetup
import org.eclipse.emf.ecore.xml.namespace.XMLNamespacePackage
import org.eclipse.emf.ecore.xml.type.XMLTypePackage
import org.eclipse.xtext.XtextPackage
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1

class OMLXcorePackages {

	public val XtextResourceSet set
	public val EPackage c
	public val EPackage t
	public val EPackage g
	public val EPackage b
	public val EPackage d

	new() {
		XcoreStandaloneSetup.doSetup()

		val omlc = "/model/OMLCommon.xcore"
		val omlc_uri = URI.createPlatformResourceURI("/gov.nasa.jpl.imce.oml.model" + omlc, false)
		val omlt = "/model/OMLTerminologies.xcore"
		val omlt_uri = URI.createPlatformResourceURI("/gov.nasa.jpl.imce.oml.model" + omlt, false)
		val omlg = "/model/OMLGraphs.xcore"
		val omlg_uri = URI.createPlatformResourceURI("/gov.nasa.jpl.imce.oml.model" + omlg, false)
		val omlb = "/model/OMLBundles.xcore"
		val omlb_uri = URI.createPlatformResourceURI("/gov.nasa.jpl.imce.oml.model" + omlb, false)
		val omld = "/model/OMLDescriptions.xcore"
		val omld_uri = URI.createPlatformResourceURI("/gov.nasa.jpl.imce.oml.model" + omld, false)

		this.set = new XtextResourceSet()
		this.set.setPackageRegistry(EPackage.Registry.INSTANCE)
		val Map<URI, URI> uriMap = set.getURIConverter().getURIMap()
		uriMap.putAll(EcorePlugin.computePlatformURIMap(false))
		uriMap.put(URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/Ecore.ecore"),
			URI.createURI(EcorePackage.getResource("/model/Ecore.ecore").toURI.toString))
		uriMap.put(URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/Ecore.genmodel"),
			URI.createURI(EcorePackage.getResource("/model/Ecore.genmodel").toURI.toString))
		uriMap.put(URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/XMLNamespace.ecore"),
			URI.createURI(XMLNamespacePackage.getResource("/model/XMLNamespace.ecore").toURI.toString))
		uriMap.put(URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/XMLNamespace.genmodel"),
			URI.createURI(XMLNamespacePackage.getResource("/model/XMLNamespace.genmodel").toURI.toString))
		uriMap.put(URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/XMLType.ecore"),
			URI.createURI(XMLTypePackage.getResource("/model/XMLType.ecore").toURI.toString))
		uriMap.put(URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/XMLType.genmodel"),
			URI.createURI(XMLTypePackage.getResource("/model/XMLType.genmodel").toURI.toString))

		val ecore = set.getResource(URI.createURI(EcorePackage.eNS_URI), true)
		if (!ecore.errors.empty) {
			throw new IllegalArgumentException("Failed to load the Ecore package")
		}
		val genModel = set.getResource(URI.createURI(GenModelPackage.eNS_URI), true)
		if (!genModel.errors.empty) {
			throw new IllegalArgumentException("Failed to load the GenModel package")
		}
		val xtext = set.getResource(URI.createURI(XtextPackage.eNS_URI), true)
		if (!xtext.errors.empty) {
			throw new IllegalArgumentException("Failed to load the Xtext package")
		}
		val xcore = set.getResource(URI.createURI(XcorePackage.eNS_URI), true)
		if (!xcore.errors.empty) {
			throw new IllegalArgumentException("Failed to load the Xcore package")
		}
		uriMap.put(omlc_uri, URI.createURI(locateXcore(omlc)))
		uriMap.put(omlt_uri, URI.createURI(locateXcore(omlt)))
		uriMap.put(omlg_uri, URI.createURI(locateXcore(omlg)))
		uriMap.put(omlb_uri, URI.createURI(locateXcore(omlb)))
		uriMap.put(omld_uri, URI.createURI(locateXcore(omld)))

		val omlc_r = set.getResource(omlc_uri, true)
		val omlt_r = set.getResource(omlt_uri, true)
		val omlg_r = set.getResource(omlg_uri, true)
		val omlb_r = set.getResource(omlb_uri, true)
		val omld_r = set.getResource(omld_uri, true)
		
		// Enabling this can result in a NoClassDefFoundError
		/*
		 * 0    [main] WARN  pes.access.impl.DeclaredTypeFactory  - --- xtext.common.types ---------------------------------------------------
1    [main] WARN  pes.access.impl.DeclaredTypeFactory  - ASM library is not available. Falling back to java.lang.reflect API.
1    [main] WARN  pes.access.impl.DeclaredTypeFactory  - Please note that no information about compile time constants is available.
1    [main] WARN  pes.access.impl.DeclaredTypeFactory  - It's recommended to use org.objectweb.asm 5.0.1 or better (Maven group id: org.ow2.asm).
1    [main] WARN  pes.access.impl.DeclaredTypeFactory  - --------------------------------------------------------------------------
Exception in thread "main" java.lang.NoClassDefFoundError: gov/nasa/jpl/imce/oml/model/bundles/bundle (wrong name: gov/nasa/jpl/imce/oml/model/bundles/Bundle)
	at java.lang.ClassLoader.defineClass1(Native Method)
	at java.lang.ClassLoader.defineClass(ClassLoader.java:763)
	at java.security.SecureClassLoader.defineClass(SecureClassLoader.java:142)
	at java.net.URLClassLoader.defineClass(URLClassLoader.java:467)
	at java.net.URLClassLoader.access$100(URLClassLoader.java:73)
	at java.net.URLClassLoader$1.run(URLClassLoader.java:368)
	at java.net.URLClassLoader$1.run(URLClassLoader.java:362)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.net.URLClassLoader.findClass(URLClassLoader.java:361)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:331)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at java.lang.Class.forName0(Native Method)
	at java.lang.Class.forName(Class.java:348)
	at org.eclipse.xtext.common.types.access.impl.DeclaredTypeFactory.createType(DeclaredTypeFactory.java:105)
	at org.eclipse.xtext.common.types.access.impl.DeclaredTypeFactory.createType(DeclaredTypeFactory.java:37)
	at org.eclipse.xtext.common.types.access.binary.BinaryClassMirror.initialize(BinaryClassMirror.java:42)
	at org.eclipse.xtext.common.types.access.TypeResource.doLoad(TypeResource.java:132)
	at org.eclipse.emf.ecore.resource.impl.ResourceImpl.load(ResourceImpl.java:1518)
	at org.eclipse.xtext.common.types.access.TypeResource.load(TypeResource.java:116)
	at org.eclipse.emf.ecore.resource.impl.ResourceSetImpl.demandLoad(ResourceSetImpl.java:259)
	at org.eclipse.emf.ecore.resource.impl.ResourceSetImpl.demandLoadHelper(ResourceSetImpl.java:274)
	at org.eclipse.xtext.resource.XtextResourceSet.getResource(XtextResourceSet.java:265)
	at org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider.findTypeByClass(ClasspathTypeProvider.java:246)
	at org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider.findTypeByName(ClasspathTypeProvider.java:192)
	at org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider.findTypeByName(ClasspathTypeProvider.java:211)
	at org.eclipse.xtext.common.types.xtext.AbstractTypeScope.getSingleElement(AbstractTypeScope.java:59)
	at org.eclipse.emf.ecore.xcore.scoping.types.TypeScopeWithWildcardImports.getSingleElement(TypeScopeWithWildcardImports.java:58)
	at org.eclipse.emf.ecore.xcore.scoping.types.AbstractKnownTypesScope.getSingleElement(AbstractKnownTypesScope.java:39)
	at org.eclipse.emf.ecore.xcore.scoping.types.AbstractKnownTypesScope.getSingleElement(AbstractKnownTypesScope.java:39)
	at org.eclipse.emf.ecore.xcore.scoping.types.PrimitiveAwareScope.getSingleElement(PrimitiveAwareScope.java:40)
	at org.eclipse.emf.ecore.xcore.scoping.types.CachingTypeScope.getSingleElement(CachingTypeScope.java:42)
	at org.eclipse.xtext.scoping.impl.AbstractScope.getSingleElement(AbstractScope.java:108)
	at org.eclipse.xtext.xbase.scoping.batch.TypeLiteralScope.getLocalElementsByName(TypeLiteralScope.java:48)
	at org.eclipse.xtext.xbase.scoping.batch.AbstractSessionBasedScope.getElements(AbstractSessionBasedScope.java:174)
	at org.eclipse.xtext.xbase.scoping.batch.AbstractSessionBasedScope.getElements(AbstractSessionBasedScope.java:176)
	at org.eclipse.xtext.xbase.scoping.batch.AbstractSessionBasedScope.getElements(AbstractSessionBasedScope.java:176)
	at org.eclipse.xtext.xbase.scoping.batch.AbstractSessionBasedScope.getElements(AbstractSessionBasedScope.java:176)
	at org.eclipse.xtext.xbase.scoping.batch.AbstractSessionBasedScope$1.get(AbstractSessionBasedScope.java:180)
	at org.eclipse.xtext.xbase.scoping.batch.AbstractSessionBasedScope$1.get(AbstractSessionBasedScope.java:177)
	at org.eclipse.xtext.scoping.impl.AbstractScope$ParentIterable.iterator(AbstractScope.java:60)
	at com.google.common.collect.Iterables$3.transform(Iterables.java:509)
	at com.google.common.collect.Iterables$3.transform(Iterables.java:506)
	at com.google.common.collect.TransformedIterator.next(TransformedIterator.java:48)
	at com.google.common.collect.Iterators$5.hasNext(Iterators.java:543)
	at com.google.common.collect.Iterators$7.computeNext(Iterators.java:645)
	at com.google.common.collect.AbstractIterator.tryToComputeNext(AbstractIterator.java:143)
	at com.google.common.collect.AbstractIterator.hasNext(AbstractIterator.java:138)
	at com.google.common.collect.Iterators$5.hasNext(Iterators.java:542)
	at com.google.common.collect.Iterators$7.computeNext(Iterators.java:645)
	at com.google.common.collect.AbstractIterator.tryToComputeNext(AbstractIterator.java:143)
	at com.google.common.collect.AbstractIterator.hasNext(AbstractIterator.java:138)
	at com.google.common.collect.Iterators$5.hasNext(Iterators.java:542)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeComputationState.getLinkingCandidates(AbstractTypeComputationState.java:412)
	at org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer._computeTypes(XbaseTypeComputer.java:1086)
	at org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer.computeTypes(XbaseTypeComputer.java:100)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeComputationState.doComputeTypes(AbstractTypeComputationState.java:121)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeComputationState.computeTypes(AbstractTypeComputationState.java:109)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeComputationState$1.getActualType(AbstractTypeComputationState.java:403)
	at org.eclipse.xtext.xbase.scoping.batch.FeatureScopes.createFeatureCallScopeForReceiver(FeatureScopes.java:215)
	at org.eclipse.xtext.xbase.scoping.batch.FeatureScopes.createFeatureCallScope(FeatureScopes.java:92)
	at org.eclipse.xtext.xbase.scoping.batch.AbstractFeatureScopeSession.createFeatureCallScope(AbstractFeatureScopeSession.java:177)
	at org.eclipse.xtext.xbase.scoping.batch.AbstractFeatureScopeSession.getScope(AbstractFeatureScopeSession.java:48)
	at org.eclipse.xtext.xbase.typesystem.internal.ScopeProviderAccess.getCandidateDescriptions(ScopeProviderAccess.java:142)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeComputationState.getLinkingCandidates(AbstractTypeComputationState.java:409)
	at org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer._computeTypes(XbaseTypeComputer.java:1086)
	at org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer.computeTypes(XbaseTypeComputer.java:100)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeComputationState.doComputeTypes(AbstractTypeComputationState.java:121)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeComputationState.computeTypes(AbstractTypeComputationState.java:109)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeComputationState$1.getActualType(AbstractTypeComputationState.java:403)
	at org.eclipse.xtext.xbase.scoping.batch.FeatureScopes.createFeatureCallScopeForReceiver(FeatureScopes.java:215)
	at org.eclipse.xtext.xbase.scoping.batch.FeatureScopes.createFeatureCallScope(FeatureScopes.java:92)
	at org.eclipse.xtext.xbase.scoping.batch.AbstractFeatureScopeSession.createFeatureCallScope(AbstractFeatureScopeSession.java:177)
	at org.eclipse.xtext.xbase.scoping.batch.AbstractFeatureScopeSession.getScope(AbstractFeatureScopeSession.java:48)
	at org.eclipse.xtext.xbase.typesystem.internal.ScopeProviderAccess.getCandidateDescriptions(ScopeProviderAccess.java:142)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeComputationState.getLinkingCandidates(AbstractTypeComputationState.java:409)
	at org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer._computeTypes(XbaseTypeComputer.java:1086)
	at org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer.computeTypes(XbaseTypeComputer.java:100)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeComputationState.doComputeTypes(AbstractTypeComputationState.java:121)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeComputationState.computeTypes(AbstractTypeComputationState.java:109)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractLinkingCandidate.resolveArgumentType(AbstractLinkingCandidate.java:627)
	at org.eclipse.xtext.xbase.typesystem.internal.FeatureLinkingCandidate.resolveArgumentType(FeatureLinkingCandidate.java:963)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractLinkingCandidate.computeFixedArityArgumentType(AbstractLinkingCandidate.java:579)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractLinkingCandidate.computeArgumentType(AbstractLinkingCandidate.java:443)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractLinkingCandidate.computeArgumentTypes(AbstractLinkingCandidate.java:430)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractLinkingCandidate.preApply(AbstractLinkingCandidate.java:378)
	at org.eclipse.xtext.xbase.typesystem.internal.FeatureLinkingCandidate.preApply(FeatureLinkingCandidate.java:896)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractLinkingCandidate.applyToComputationState(AbstractLinkingCandidate.java:286)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeComputationState$5.applyToComputationState(AbstractTypeComputationState.java:511)
	at org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer._computeTypes(XbaseTypeComputer.java:1091)
	at org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer.computeTypes(XbaseTypeComputer.java:100)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeComputationState.doComputeTypes(AbstractTypeComputationState.java:121)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeComputationState.computeTypes(AbstractTypeComputationState.java:109)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractLinkingCandidate.resolveArgumentType(AbstractLinkingCandidate.java:627)
	at org.eclipse.xtext.xbase.typesystem.internal.FeatureLinkingCandidate.resolveArgumentType(FeatureLinkingCandidate.java:963)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractLinkingCandidate.computeFixedArityArgumentType(AbstractLinkingCandidate.java:579)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractLinkingCandidate.computeArgumentType(AbstractLinkingCandidate.java:443)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractPendingLinkingCandidate.getConformanceFlags(AbstractPendingLinkingCandidate.java:993)
	at org.eclipse.xtext.xbase.typesystem.internal.FeatureLinkingCandidate.getConformanceFlags(FeatureLinkingCandidate.java:551)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractPendingLinkingCandidate.compareByArgumentTypes(AbstractPendingLinkingCandidate.java:797)
	at org.eclipse.xtext.xbase.typesystem.internal.FeatureLinkingCandidate.compareByArgumentTypes(FeatureLinkingCandidate.java:613)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractPendingLinkingCandidate.compareByArgumentTypes(AbstractPendingLinkingCandidate.java:673)
	at org.eclipse.xtext.xbase.typesystem.internal.FeatureLinkingCandidate.compareByArgumentTypes(FeatureLinkingCandidate.java:604)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractPendingLinkingCandidate.compareTo(AbstractPendingLinkingCandidate.java:582)
	at org.eclipse.xtext.xbase.typesystem.internal.FeatureLinkingCandidate.compareTo(FeatureLinkingCandidate.java:742)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractPendingLinkingCandidate.compareTo(AbstractPendingLinkingCandidate.java:517)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractPendingLinkingCandidate.getPreferredCandidate(AbstractPendingLinkingCandidate.java:479)
	at org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer.getBestCandidate(XbaseTypeComputer.java:1098)
	at org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer._computeTypes(XbaseTypeComputer.java:1087)
	at org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer.computeTypes(XbaseTypeComputer.java:100)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeComputationState.doComputeTypes(AbstractTypeComputationState.java:121)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeComputationState.computeTypes(AbstractTypeComputationState.java:109)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeComputationState$1.getActualType(AbstractTypeComputationState.java:403)
	at org.eclipse.xtext.xbase.scoping.batch.FeatureScopes.createFeatureCallScopeForReceiver(FeatureScopes.java:215)
	at org.eclipse.xtext.xbase.scoping.batch.FeatureScopes.createFeatureCallScope(FeatureScopes.java:92)
	at org.eclipse.xtext.xbase.scoping.batch.AbstractFeatureScopeSession.createFeatureCallScope(AbstractFeatureScopeSession.java:177)
	at org.eclipse.xtext.xbase.scoping.batch.AbstractFeatureScopeSession.getScope(AbstractFeatureScopeSession.java:48)
	at org.eclipse.xtext.xbase.typesystem.internal.ScopeProviderAccess.getCandidateDescriptions(ScopeProviderAccess.java:142)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeComputationState.getLinkingCandidates(AbstractTypeComputationState.java:409)
	at org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer._computeTypes(XbaseTypeComputer.java:1086)
	at org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer.computeTypes(XbaseTypeComputer.java:100)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeComputationState.doComputeTypes(AbstractTypeComputationState.java:121)
	at org.eclipse.xtext.xbase.typesystem.internal.ExpressionTypeComputationState.doComputeTypes(ExpressionTypeComputationState.java:59)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeComputationState.computeTypes(AbstractTypeComputationState.java:109)
	at org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer._computeTypes(XbaseTypeComputer.java:473)
	at org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer.computeTypes(XbaseTypeComputer.java:106)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeComputationState.doComputeTypes(AbstractTypeComputationState.java:121)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeComputationState.computeTypes(AbstractTypeComputationState.java:109)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractRootTypeComputationState.computeTypes(AbstractRootTypeComputationState.java:32)
	at org.eclipse.xtext.xbase.typesystem.internal.LogicalContainerAwareReentrantTypeResolver._computeTypes(LogicalContainerAwareReentrantTypeResolver.java:827)
	at org.eclipse.xtext.xbase.typesystem.internal.LogicalContainerAwareReentrantTypeResolver.computeTypes(LogicalContainerAwareReentrantTypeResolver.java:711)
	at org.eclipse.xtext.xbase.typesystem.internal.LogicalContainerAwareReentrantTypeResolver.computeMemberTypes(LogicalContainerAwareReentrantTypeResolver.java:897)
	at org.eclipse.xtext.xbase.typesystem.internal.LogicalContainerAwareReentrantTypeResolver._computeTypes(LogicalContainerAwareReentrantTypeResolver.java:886)
	at org.eclipse.xtext.xbase.typesystem.internal.LogicalContainerAwareReentrantTypeResolver.computeTypes(LogicalContainerAwareReentrantTypeResolver.java:705)
	at org.eclipse.xtext.xbase.typesystem.internal.LogicalContainerAwareReentrantTypeResolver.computeTypes(LogicalContainerAwareReentrantTypeResolver.java:697)
	at org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver.resolve(DefaultReentrantTypeResolver.java:163)
	at org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver.reentrantResolve(DefaultReentrantTypeResolver.java:139)
	at org.eclipse.xtext.xbase.typesystem.internal.CompoundReentrantTypeResolver.reentrantResolve(CompoundReentrantTypeResolver.java:79)
	at org.eclipse.xtext.xbase.typesystem.internal.CachingBatchTypeResolver$LazyResolvedTypes.resolveTypes(CachingBatchTypeResolver.java:80)
	at org.eclipse.xtext.xbase.typesystem.internal.CachingBatchTypeResolver$2.process(CachingBatchTypeResolver.java:57)
	at org.eclipse.xtext.xbase.typesystem.internal.CachingBatchTypeResolver$2.process(CachingBatchTypeResolver.java:53)
	at org.eclipse.xtext.util.concurrent.IUnitOfWork$Void.exec(IUnitOfWork.java:37)
	at org.eclipse.xtext.util.OnChangeEvictingCache.execWithoutCacheClear(OnChangeEvictingCache.java:129)
	at org.eclipse.xtext.xbase.typesystem.internal.CachingBatchTypeResolver.doResolveTypes(CachingBatchTypeResolver.java:53)
	at org.eclipse.xtext.xbase.typesystem.internal.AbstractBatchTypeResolver.resolveTypes(AbstractBatchTypeResolver.java:69)
	at org.eclipse.xtext.xbase.resource.BatchLinkingService.resolveBatched(BatchLinkingService.java:60)
	at org.eclipse.xtext.xbase.resource.BatchLinkingService.resolveBatched(BatchLinkingService.java:41)
	at org.eclipse.xtext.xbase.resource.BatchLinkableResource.getEObject(BatchLinkableResource.java:117)
	at org.eclipse.emf.ecore.xcore.resource.XcoreResource.getEObject(XcoreResource.java:186)
	at org.eclipse.emf.ecore.resource.impl.ResourceSetImpl.getEObject(ResourceSetImpl.java:223)
	at org.eclipse.emf.ecore.util.EcoreUtil.resolve(EcoreUtil.java:199)
	at org.eclipse.emf.ecore.util.EcoreUtil.resolve(EcoreUtil.java:259)
	at org.eclipse.emf.ecore.impl.BasicEObjectImpl.eResolveProxy(BasicEObjectImpl.java:1477)
	at org.eclipse.xtext.xbase.impl.XConstructorCallImpl.getConstructor(XConstructorCallImpl.java:194)
	at org.eclipse.xtext.xbase.impl.XConstructorCallImpl.eGet(XConstructorCallImpl.java:363)
	at org.eclipse.emf.ecore.impl.BasicEObjectImpl.eGet(BasicEObjectImpl.java:1011)
	at org.eclipse.emf.ecore.impl.BasicEObjectImpl.eGet(BasicEObjectImpl.java:1003)
	at org.eclipse.emf.ecore.util.EContentsEList$FeatureIteratorImpl.hasNext(EContentsEList.java:439)
	at org.eclipse.emf.ecore.util.EcoreUtil.resolveCrossReferences(EcoreUtil.java:304)
	at org.eclipse.emf.ecore.util.EcoreUtil.resolveAll(EcoreUtil.java:298)
	at org.eclipse.emf.ecore.util.EcoreUtil.resolveAll(EcoreUtil.java:283)
	at org.eclipse.emf.ecore.util.EcoreUtil.resolveAll(EcoreUtil.java:271)
	at gov.nasa.jpl.imce.oml.model.extensions.OMLXcorePackages.<init>(OMLXcorePackages.java:122)
	at gov.nasa.jpl.imce.oml.development.generators.OMLUtilities.<init>(OMLUtilities.java:64)
	at gov.nasa.jpl.imce.oml.development.generators.OMLSpecificationResolverAPIGenerator.<init>(OMLSpecificationResolverAPIGenerator.java:45)
	at gov.nasa.jpl.imce.oml.development.generators.OMLSpecificationResolverAPIGenerator.main(OMLSpecificationResolverAPIGenerator.java:53)
		 
		 */
		//EcoreUtil.resolveAll(set)

		this.c = omlc_r.getContents().filter(EPackage).get(0)
		this.t = omlt_r.getContents().filter(EPackage).get(0)
		this.g = omlg_r.getContents().filter(EPackage).get(0)
		this.b = omlb_r.getContents().filter(EPackage).get(0)
		this.d = omld_r.getContents().filter(EPackage).get(0)
	}

	static def String locateXcore(String path) {
		val url = CommonPackage.getResource(path)
		if (null !== url)
			url.toURI.toString
		else {
			val binURL = CommonPackage.getResource("/gov/nasa/jpl/imce/oml/model/extensions/OMLExtensions.xtend")
			if (null === binURL)
				throw new IllegalArgumentException("locateXcore: failed to locate path: "+path)
			val Path binPath = Paths.get(binURL.toURI)
			val xcorePath = binPath.parent.parent.parent.parent.parent.parent.parent.parent.parent.resolve(path.substring(1))
			val located = xcorePath.toAbsolutePath.toString
			located
		}
	}
	
	static def XtextResourceSet createXcoreResourceSet(Procedure1<Map<URI, URI>> standaloneURIMapInitializer) {
		val set = new XtextResourceSet();
		set.setPackageRegistry(EPackage.Registry.INSTANCE)
		val Map<URI, URI> uriMap = set.getURIConverter().getURIMap()
		if (null === EcorePlugin.workspaceRoot) {
			XcoreStandaloneSetup.doSetup()
			uriMap.putAll(EcorePlugin.computePlatformURIMap(false))
			uriMap.put(URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/Ecore.ecore"),
				URI.createURI(EcorePackage.getResource("/model/Ecore.ecore").toURI.toString))
			uriMap.put(URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/Ecore.genmodel"),
				URI.createURI(EcorePackage.getResource("/model/Ecore.genmodel").toURI.toString))
			uriMap.put(URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/XMLNamespace.ecore"),
				URI.createURI(XMLNamespacePackage.getResource("/model/XMLNamespace.ecore").toURI.toString))
			uriMap.put(URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/XMLNamespace.genmodel"),
				URI.createURI(XMLNamespacePackage.getResource("/model/XMLNamespace.genmodel").toURI.toString))
			uriMap.put(URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/XMLType.ecore"),
				URI.createURI(XMLTypePackage.getResource("/model/XMLType.ecore").toURI.toString))
			uriMap.put(URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/XMLType.genmodel"),
				URI.createURI(XMLTypePackage.getResource("/model/XMLType.genmodel").toURI.toString))

			val ecore = set.getResource(URI.createURI(EcorePackage.eNS_URI), true)
			if (!ecore.errors.empty) {
				throw new IllegalArgumentException("Failed to load the Ecore package")
			}
			val genModel = set.getResource(URI.createURI(GenModelPackage.eNS_URI), true)
			if (!genModel.errors.empty) {
				throw new IllegalArgumentException("Failed to load the GenModel package")
			}
			val xtext = set.getResource(URI.createURI(XtextPackage.eNS_URI), true)
			if (!xtext.errors.empty) {
				throw new IllegalArgumentException("Failed to load the Xtext package")
			}
			val xcore = set.getResource(URI.createURI(XcorePackage.eNS_URI), true)
			if (!xcore.errors.empty) {
				throw new IllegalArgumentException("Failed to load the Xcore package")
			}
			standaloneURIMapInitializer.apply(uriMap)
		} else {
			uriMap.putAll(EcorePlugin.computePlatformURIMap(true))
		}
		set.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE)
		set
	}

}
