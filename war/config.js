System.config({
    paths: {
        'googleapis:': 'https://ajax.googleapis.com/ajax/libs/'
    },
    map: {
        'angular': 'googleapis:angularjs/1.6.1/angular.min.js',
        'angular-animate': 'googleapis:angularjs/1.6.1/angular-animate.min.js',
        'angular-aria': 'googleapis:angularjs/1.6.1/angular-aria.min.js',
        'angular-material': 'googleapis:angular_material/1.1.1/angular-material.min.js',
        'angular-messages': 'googleapis:angularjs/1.6.1/angular-messages.min.js',
        'angular-sanitize': 'googleapis:angularjs/1.6.1/angular-sanitize.min.js'
    },
    meta: {
        'angular': { format: 'global' },
        'angular-animate': { format: 'global' },
        'angular-aria': { format: 'global' },
        'angular-material': { format: 'global' },
        'angular-messages': { format: 'global' },
        'angular-sanitize': { format: 'global' }
    },
    packages: {
        './assets/js': {
            defaultExtension: 'js'
        }
    }
});
System.import('portal').catch(console.error.bind(console));