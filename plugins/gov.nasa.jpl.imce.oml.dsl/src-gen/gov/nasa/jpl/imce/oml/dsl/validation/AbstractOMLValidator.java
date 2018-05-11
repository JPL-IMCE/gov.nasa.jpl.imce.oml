/*
 * Copyright 2017 California Institute of Technology (\"Caltech\").
 * U.S. Government sponsorship acknowledged.
 *
 * Licensed under the Apache License, Version 2.0 (the \"License\");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an \"AS IS\" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gov.nasa.jpl.imce.oml.dsl.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.validation.NamesAreUniqueValidator;

@ComposedChecks(validators = {NamesAreUniqueValidator.class})
public abstract class AbstractOMLValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://imce.jpl.nasa.gov/oml/common"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://imce.jpl.nasa.gov/oml/terminologies"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://imce.jpl.nasa.gov/oml/graphs"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://imce.jpl.nasa.gov/oml/bundles"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://imce.jpl.nasa.gov/oml/descriptions"));
		return result;
	}
	
}
