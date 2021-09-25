function drinkWater(obj) {
    const hydratationAmo = 0.1;
    if (obj.dizziness) {
        obj.levelOfHydrated += hydratationAmo * obj.weight * obj.experience;
        obj.dizziness = false;
    }
    return obj;
}
