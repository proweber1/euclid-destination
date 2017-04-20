# coding: utf8

from math import sqrt

critics = {
	'Lisa Rose': {
		'Lady in the Water': 2.5,
		'Snakes on a Plane': 3.5,
		'Just my luck': 3.0,
		'Superman returns': 3.5,
		'You, Me and Dupree': 2.5,
		'The Night Listener': 3.0
	},
	'Gene Seymour': {
		'Lady in the Water': 3.0,
		'Snakes on a Plane': 3.5,
		'Just my luck': 1.5,
		'Superman returns': 5.0,
		'You, Me and Dupree': 3.5,
		'The Night Listener': 3.0
	}
}

def sim_distance(prefs, person1, person2):
  si = {}
  for item in prefs[person1]:
    for item in prefs[person2]:
      si[item] = 1

    if (len(si) == 0):
      return 0

    sum_of_squares = sum([pow(prefs[person1][item]-prefs[person2][item], 2)
    	for item in prefs[person1] if item in prefs[person2]])

  return 1/(1 + sum_of_squares)

