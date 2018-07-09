### Release process

See the [Publishing Process](publishProcess.markdown) for publishing a new version.

The OML Workbench repository is organized as a [Mono Repository](https://developer.atlassian.com/blog/2015/10/monorepos-in-git/).
This means that there is a single version for every artifact published (i.e., the OML Workbench product, features, plugins, update site, ...).
Since all of these artifacts are about a cohesive topic, i.e., OML, a change to OML typically results in affecting several artifacts.
For developers that depend on OML, it is simpler to manage a single version regardless of which subset of OML artifacts are used
than to have multiple artifact-specific versions to manage.
