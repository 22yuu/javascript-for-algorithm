import * as fs from 'fs';
import path from 'path';

const __dirname = path.resolve();

function getDirList(dir) {
  try {
    return fs
      .readdirSync(dir, { encoding: 'utf-8', withFileTypes: true })
      .filter((dirent) => dirent.isDirectory())
      .map((dirent) => dirent.name.normalize('NFC'))
      .sort();
  } catch (error) {
    console.log(error);
    return [];
  }
}

export function getDomainDirList(domain) {
  const domainDir = path.resolve(__dirname, domain);
  const stepList = getDirList(domainDir);

  const countArray = stepList.map((step) => {
    const stepDir = path.resolve(domainDir, step);

    const filesLength = fs.readdirSync(stepDir).length; // return array - all files names

    return filesLength;
  });

  // 두 배열을 하나의 객체로 합친다.
  const merged = stepList.reduce(
    (obj, key, index) => ({ ...obj, [key]: countArray[index] }),
    {}
  );

  return merged;
}
