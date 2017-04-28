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

def sim_distance(items, person1, person2):
    general_items = [item for item in items[person1] if item in items[person2]]

    if 0 == len(general_items):
        return 0

    return 1/(1 + sum([pow(items[person1][item] - items[person2][item], 2) for item in general_items]))

