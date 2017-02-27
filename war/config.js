System.config({
    paths: {
        'googleapis:': 'https://ajax.googleapis.com/ajax/libs/'
    },
    map: {
        'angular': 'googleapis:angularjs/1.6.2/angular.min.js'
    },
    meta: {
        'angular': { format: 'global' }
    },
    packages: {
        './assets/js': {
            defaultExtension: 'js'
        }
    }
});
System.import('portal').catch(console.error.bind(console));
